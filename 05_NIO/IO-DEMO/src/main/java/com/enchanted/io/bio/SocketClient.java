package com.enchanted.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName: SocketClient
 * @Description: TODO：客户端1
 * @PackageName:com.enchanted.io.bio
 * @Author Enchanted
 * @Date 2023/11/3 13:52
 * @Version 1.0
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 连接服务器
        Socket socket = new Socket("localhost", 9091);
        // 发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello bio from client 1".getBytes());
        outputStream.flush();
        // 接收服务器返回的数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println("接收到服务器返回的数据：" + new String(bytes, 0, len));
        // 关闭服务器
        socket.close();
    }
}
