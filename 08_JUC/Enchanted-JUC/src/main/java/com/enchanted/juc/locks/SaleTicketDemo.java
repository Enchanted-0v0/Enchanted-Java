package com.enchanted.juc.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SaleTicketDemo
 * @Description: TODO: ReentrantLock抢票案例
 * @PackageName:com.enchanted.juc.locks
 * @Author Enchanted
 * @Date 2023/11/11 22:29
 * @Version 1.0
 */

class Ticket //资源类，模拟3个售票员卖完50张票
{
    private int number = 50;
    //ReentrantLock lock = new ReentrantLock();
    ReentrantLock lock = new ReentrantLock(true);

    public void sale()
    {
        lock.lock();
        try
        {
            if(number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"卖出第：\t"+(number--)+"\t 还剩下:"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SaleTicketDemo {
    public static void main(String[] args)//一切程序的入口
    {
        Ticket ticket = new Ticket();

        new Thread(() -> { for (int i = 0; i <55; i++)  ticket.sale(); },"a").start();
        new Thread(() -> { for (int i = 0; i <55; i++)  ticket.sale(); },"b").start();
        new Thread(() -> { for (int i = 0; i <55; i++)  ticket.sale(); },"c").start();
    }
}
