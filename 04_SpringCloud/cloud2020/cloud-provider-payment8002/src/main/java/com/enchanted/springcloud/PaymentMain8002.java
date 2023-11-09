package com.enchanted.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.HashMap;

/**
 * @ClassName: PaymentMain8002
 * @Description: TODO: Payment8002 主启动类
 * @PackageName:com.enchanted.springcloud
 * @Author Enchanted
 * @Date 2023/11/7 18:08
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }

}
