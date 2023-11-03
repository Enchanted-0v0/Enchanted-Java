package com.enchanted.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: SocketServerMultipleThread
 * @Description: TODO: 多线程服务端
 * @PackageName:com.enchanted.io.bio
 * @Author Enchanted
 * @Date 2023/11/3 15:15
 * @Version 1.0
 */
public class SocketServerMultipleThread {
    public static void main(String[] args) throws IOException {
        //1.创建服务端的Socket
        ServerSocket serverSocket = new ServerSocket(9091);
        while(true){
            System.out.println("等待客户端的连接");
            //阻塞等待客户端的连接
            Socket socket = serverSocket.accept();
            System.out.println("已有客户端连接了");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handle(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

    private static void handle(Socket socket) throws IOException {

        //开始处理客户端的读写请求
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        //阻塞的等待客户端向io流通道中写数据
        int len = inputStream.read(bytes);
        System.out.println("收到客户端的数据："+new String(bytes,0,len));
        //服务端返回信息给客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("success".getBytes());
        outputStream.flush();

    }
}
