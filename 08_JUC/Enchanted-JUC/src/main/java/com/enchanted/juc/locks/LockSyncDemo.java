package com.enchanted.juc.locks;

/**
 * @ClassName: LockSyncDemo
 * @Description: TODO
 * @PackageName:com.enchanted.juc.locks
 * @Author Enchanted
 * @Date 2023/11/11 16:15
 * @Version 1.0
 */
public class LockSyncDemo {

    Object object = new Object();

    public void m1()
    {
        synchronized (object)
        {
            System.out.println("----hello synchronized code block");
            throw new RuntimeException("-----exp");
        }
    }
    public synchronized void m2()
    {
        System.out.println("----hello synchronized m2");
    }

    public static synchronized void m3()
    {
        System.out.println("----hello static synchronized m3");
    }

    public static void main(String[] args) {

    }
}
