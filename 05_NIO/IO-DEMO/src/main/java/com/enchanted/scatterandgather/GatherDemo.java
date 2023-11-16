package com.enchanted.scatterandgather;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: GatherDemo
 * @Description: TODO: 聚集
 * @PackageName:com.enchanted.scatterandgather
 * @Author Enchanted
 * @Date 2023/11/16 08:11
 * @Version 1.0
 */
public class GatherDemo {

    public static void main(String[] args) throws Exception {
        //创建随机访问流
        RandomAccessFile file = new RandomAccessFile("6.txt","rw");
        //得到Channel
        FileChannel channel = file.getChannel();
        //创建2个buffer对象
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        //存入数据到buffer1
        String data1 = "hello buffer1";
        buffer1.put(data1.getBytes());
        buffer1.flip();
        //存入数据到buffer2
        String data2 = "hello buffer2";
        buffer2.put(data2.getBytes());
        buffer2.flip();
        //channel写数据
        channel.write(new ByteBuffer[]{buffer1,buffer2});
        //关闭file流
        channel.close();
    }



}
