package com.enchanted.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @ClassName: NIOClient
 * @Description: TODO: NIO客户端
 * @PackageName:com.enchanted.io.nio
 * @Author Enchanted
 * @Date 2023/11/4 14:13
 * @Version 1.0
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        // 获得channel通道
        SocketChannel channel = SocketChannel.open();
        // 设置为非阻塞
        channel.configureBlocking(false);
        // 获得Selector
        Selector selector = Selector.open();
        // 客户端连接上服务端
        channel.connect(new InetSocketAddress("127.0.0.1", 9091));
        // 将channel注册到Selector上，并监听连接事件
        channel.register(selector, SelectionKey.OP_CONNECT);
        // 轮询访问Selector
        while (true) {
            //阻塞的，在客户端的角度这个方法只面向一个客户端的Channel
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isConnectable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    // 如果是正在连接，则完成连接
                    if (socketChannel.isConnectionPending()) {
                        // finishConnect这个方法执行才表示连接完成了
                        socketChannel.finishConnect();
                        // 设置为非阻塞模型
                        socketChannel.configureBlocking(false);
                        //给服务端发消息
                        ByteBuffer byteBuffer = ByteBuffer.wrap("hello server".getBytes());
                        socketChannel.write(byteBuffer);
                        //获得服务端返回的数据
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                } else if (key.isReadable()) {
                    //读服务端返回的数据
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    //创建缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //读缓冲区中的数据
                    int len = socketChannel.read(buffer);
                    if (len != -1) {
                        System.out.println("服务端返回的数据是：" + new String(buffer.array(), 0, len));
                    }
                }
                //防止事件被重复处理
                iterator.remove();
            }
        }
    }

}
