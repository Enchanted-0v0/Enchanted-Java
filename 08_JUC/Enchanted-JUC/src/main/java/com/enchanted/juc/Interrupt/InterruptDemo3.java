package com.enchanted.juc.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: InterruptDemo3
 * @Description: TODO
 * @PackageName:com.enchanted.juc.Interrupt
 * @Author Enchanted
 * @Date 2023/11/13 13:43
 * @Version 1.0
 */
public class InterruptDemo3 {
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> {
            while (true)
            {
                if(Thread.currentThread().isInterrupted())
                {
                    System.out.println(Thread.currentThread().getName()+"\t " +
                            "中断标志位："+Thread.currentThread().isInterrupted()+" 程序停止");
                    break;
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();//为什么要在异常处，再调用一次？？
                    e.printStackTrace();
                }

                System.out.println("-----hello InterruptDemo3");
            }
        }, "t1");
        t1.start();

        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> t1.interrupt(),"t2").start();
    }
}
