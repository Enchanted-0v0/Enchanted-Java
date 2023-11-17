package com.enchanted.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentMain8004
 * @Description: TODO: PaymentMain8004 主启动类
 * @PackageName:com.enchanted
 * @Author Enchanted
 * @Date 2023/11/17 01:04
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}

