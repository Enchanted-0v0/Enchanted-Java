package com.enchanted.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: SocketServerSingleThread
 * @Description: TODO：单线程服务端
 * @PackageName:com.enchanted.io.bio
 * @Author Enchanted
 * @Date 2023/11/3 13:40
 * @Version 1.0
 */
public class SocketServerSingleThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9091);
        while (true) {
            System.out.println("等待客户端的连接");
            // 阻塞等待
            Socket socket = serverSocket.accept();
            System.out.println("已有客户端连接");
            // 开始处理
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            // 阻塞等待客户端发送数据
            int len = inputStream.read(bytes);
            System.out.println("收到客户端的数据：" + new String(bytes, 0, len));
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("success".getBytes());
            outputStream.flush();
        }
    }
}
