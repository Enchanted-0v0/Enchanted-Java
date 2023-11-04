package com.enchanted.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: NIOServer
 * @Description: TODO：NIO服务端
 * @PackageName:com.enchanted.io.nio
 * @Author Enchanted
 * @Date 2023/11/3 22:31
 * @Version 1.0
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel对象, open()为静态方法
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 设置为非阻塞的方式
        ssc.configureBlocking(false);
        // 设置服务端程序端口
        ssc.socket().bind(new InetSocketAddress(9091));
        // 创建Selector多路复用器
        Selector selector = Selector.open();
        // 把ServerSocketChannel对象注册到Selector上，并且告知对客户端的连接这样的事件感兴趣的
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while(true) {
            System.out.println("等待事件发生");
            // 阻塞，轮询监听所有注册到selector上的channel
            int select = selector.select();
            System.out.println("某个事件发生了");
            // 获得所有发生事件的channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 遍历所有的channel
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()) {
                // selectionKey==>对应着一个channel
                SelectionKey selectionKey = iterator.next();
                handle(selectionKey);
                // 防止重复处理
                iterator.remove();
            }

        }
    }

    private static void handle(SelectionKey selectionKey) throws IOException {
        // 判断channel上发生了什么事件
        if(selectionKey.isAcceptable()){
            System.out.println("有客户端连接了");
            // 服务端处理客户端的连接,得到ServerSocketChannel，代表着服务端
            //  SelectableChannel channel = selectionKey.channel(); 拿到的是SelectableChannel,故要强转
            ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
            // 服务端接收客户端的连接，得到socketChannel，建立起了服务端和客户端具体的连接通道（这个方法是阻塞的，但是调用这个方法时候一定是有连接请求的，所以是非阻塞）
            SocketChannel socketChannel = channel.accept();
            // 把socketChannel设置成非阻塞
            socketChannel.configureBlocking(false);
            // 把socketChannel注册到selector上，并且关心读事件的发生。
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
        }else if(selectionKey.isReadable()) {
            System.out.println("有客户端向服务端写数据");
            // 获得服务端和客户端之间的通道SocketChannel
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            // 创建Buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 通过socketChannel把数据读到buffer中，返回的是这一次读的字节个数
            // NIO非阻塞的体现，read本身就是非阻塞的，read方法在执行的时刻一定是客户端的写的操作发生了。
            int len = socketChannel.read(buffer);
            if(len != -1) {
                System.out.println("读到客户端的数据："+new String(buffer.array(),0,len));
            }
            //服务端返回数据给客户端
            ByteBuffer byteBuffer = ByteBuffer.wrap("hello nio".getBytes());
            //由通道去写数据
            socketChannel.write(byteBuffer);
            //监听下一次事件，读或者写
            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
    }
}
