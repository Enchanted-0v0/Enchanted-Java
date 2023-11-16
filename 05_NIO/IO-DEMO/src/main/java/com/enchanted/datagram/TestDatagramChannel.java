package com.enchanted.datagram;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: TestDatagramChannel
 * @Description: TODO
 * @PackageName:com.enchanted.datagram
 * @Author Enchanted
 * @Date 2023/11/16 07:12
 * @Version 1.0
 */
public class TestDatagramChannel {

    // 发送方
    @Test
    public void testSend() throws IOException {
       // 获得DatagramChannel
        DatagramChannel datagramChannel = DatagramChannel.open();

        // 创建地址对象
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9001);

        // 第一种方式：创建Buffer, 并写入数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello datagram channel".getBytes());
        buffer.flip();

        // 第二种方式：创建Buffer, 并写入数据
        // ByteBuffer buffer = ByteBuffer.wrap("hello datagram channel".getBytes(StandardCharsets.UTF_8));

        // 发送消息
        datagramChannel.send(buffer, socketAddress);
    }

    // 接收方
    @Test
    public void testReceive() throws IOException {
        // 获得DatagramChannel
        DatagramChannel datagramChannel = DatagramChannel.open();

        // 创建地址对象
        InetSocketAddress socketAddress = new InetSocketAddress(9001);

        // 绑定端口到Channel上
        datagramChannel.bind(socketAddress);

        // 创建Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true) {
            buffer.clear();
            SocketAddress address = datagramChannel.receive(buffer);
            buffer.flip();
            System.out.println(address.toString()+"发来消息："+new String(buffer.array(),0,buffer.limit()));
        }
    }

    @Test
    public void testReadAndWrite() throws IOException {

        //获得DatagramChannel
        DatagramChannel datagramChannel = DatagramChannel.open();
        //绑定
        datagramChannel.bind(new InetSocketAddress(9002));
        //连接
        datagramChannel.connect(new InetSocketAddress("127.0.0.1",9002));
        //write
        datagramChannel.write(ByteBuffer.wrap("hello read and write".getBytes()));
        //read
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            datagramChannel.read(buffer);
            buffer.flip();
            System.out.println("收到的消息："+new String(buffer.array(),0,buffer.limit()));
        }

    }
}
