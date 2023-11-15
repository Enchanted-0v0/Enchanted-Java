package com.enchanted.juc.Interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName: InterruptDemo
 * @Description: TODO
 * @PackageName:com.enchanted.juc.Interrupt
 * @Author Enchanted
 * @Date 2023/11/12 10:11
 * @Version 1.0
 */
public class InterruptDemo {
    static volatile boolean isStop = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {
         // m1_volatile();
        // m2_atomicBoolean();
        m3_interrupt();
    }

    private static void m3_interrupt() {
        Thread t1 = new Thread(()->{
            while(true){
                if(Thread.currentThread().isInterrupted()){//如果这个标志位被其他线程改为true了
                    System.out.println(Thread.currentThread().getName()+"\t isInterrupted（）被修改力true，程序停止");
                    break;
                }
                System.out.println("t1 ------interrupt api");//----------------------如果没停止，那就一直打印
            }
        },"t1");
        t1.start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}

        // t2向t1发出协商，将t1的中断标志位设为true, 希望t1停下来
        new Thread(()->{
            t1.interrupt();
        },"t2").start();
         // 也可以t1自己设置
        // t1.interrupt();

    }

    private static void m2_atomicBoolean() {
        new Thread(()->{
            while(true){
                if(atomicBoolean.get()){//如果这个标志位被其他线程改为true了
                    System.out.println(Thread.currentThread().getName()+"\t atomicBoolean被修改为true，程序终止");
                    break;
                }
                System.out.println("t1 ------hello atomicBoolean");//----------------------如果没停止，那就一直打印
            }
        },"t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}

        new Thread(()->{
            atomicBoolean.set(true);
        },"t2").start();
    }

    private static void m1_volatile() {
        new Thread(()->{
            while(true){
                if(isStop){//如果这个标志位被其他线程改为true了
                    System.out.println(Thread.currentThread().getName()+"\t isStop被修改为true，程序终止");
                    break;
                }
                System.out.println("t1 ------hello volatile");//----------------------如果没停止，那就一直打印
            }
        },"t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}

        new Thread(()->{
            isStop = true;
        },"t2").start();
    }
}
