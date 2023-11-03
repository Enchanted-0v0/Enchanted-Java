package com.enchanted.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName: SocketClient2
 * @Description: TODO: 客户端2
 * @PackageName:com.enchanted.io.bio
 * @Author Enchanted
 * @Date 2023/11/3 13:52
 * @Version 1.0
 */
public class SocketClient2 {
    public static void main(String[] args) throws IOException {
        //1.连接服务端
        Socket socket = new Socket("localhost",9091);
        //2.发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello bio from client 2".getBytes());
        outputStream.flush();
        //3.接收服务端返回的数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println("接收到服务端返回的数据："+new String(bytes,0,len));
        //关闭连接
        socket.close();
    }
}
