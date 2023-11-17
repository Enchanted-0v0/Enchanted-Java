package com.enchanted.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OrderZKMain80
 * @Description: TODO: 订单服务主启动类
 * @PackageName:com.enchanted.springcloud
 * @Author Enchanted
 * @Date 2023/11/17 12:15
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class, args);
    }
}

