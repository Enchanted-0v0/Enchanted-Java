package com.enchanted.juc.locks;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Lock8Demo
 * @Description: TODO: 8. 有1个静态同步方法，有1个普通同步方法,有2部手机，请问先打印邮件还是短信
 * @PackageName:com.enchanted.juc.locks
 * @Author Enchanted
 * @Date 2023/11/10 23:12
 * @Version 1.0
 */

class Phone //资源类
{
    public static synchronized void sendEmail() {

        // 暂停3秒，保证线程先活动
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-----sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("-----sendSMS");
    }

    public void hello() {
        System.out.println("-----hello");
    }

}

public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone.sendEmail();
        }, "a").start();

        // 暂停200毫秒，保证线程先活动
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
//             phone.sendSMS();
            // phone.hello();
             phone2.sendSMS();
        }, "b").start();
    }
}
