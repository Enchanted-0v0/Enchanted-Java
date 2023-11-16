package com.enchanted.scatterandgather;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: ScatterDemo
 * @Description: TODO: 分散
 * @PackageName:com.enchanted.scatterandgather
 * @Author Enchanted
 * @Date 2023/11/16 08:10
 * @Version 1.0
 */
public class ScatterDemo {
    public static void main(String[] args) throws Exception {
        //随机访问流
        RandomAccessFile file = new RandomAccessFile("1.txt","rw");
        //得到channel
        FileChannel channel = file.getChannel();
        //创建两个Buffer
        ByteBuffer buffer1 = ByteBuffer.allocate(5);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        //channel读文件中的数据存入到buffer中
        ByteBuffer[] byteBuffers = new ByteBuffer[]{buffer1,buffer2};
        long len = 0;
        while((len = channel.read(byteBuffers))!=-1){
        }
        //打印出两个buffer中的数据
        buffer1.flip();
        buffer2.flip();
        System.out.println("buffer1:"+new String(buffer1.array(),0,buffer1.limit()));
        System.out.println("buffer2:"+new String(buffer2.array(),0,buffer2.limit()));
        file.close();

    }
}
