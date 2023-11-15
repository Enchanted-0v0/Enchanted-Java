package com.enchanted.channel.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: ServerSocketChannelDemo
 * @Description: TODO: ServerSocketChannel
 * @PackageName:com.enchanted.channel.socket
 * @Author Enchanted
 * @Date 2023/11/15 16:03
 * @Version 1.0
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //绑定端口
        ssc.socket().bind(new InetSocketAddress(9091));
        //设置成非阻塞的模式
         ssc.configureBlocking(false);
        //监听客户端连接
        while(true){
            System.out.println("等待连接...");
            //当有客户端连接上来，则创建出SocketChannel对象
            SocketChannel socketChannel = ssc.accept();
            if(socketChannel!=null){
                System.out.println("有连接了："+socketChannel.socket().getRemoteSocketAddress());
            }else{
                System.out.println("继续等待");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
