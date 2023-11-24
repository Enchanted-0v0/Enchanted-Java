package com.enchanted.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: GateWayMain9527
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud
 * @Author Enchanted
 * @Date 2023/11/24 08:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527
{
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
    }
}

