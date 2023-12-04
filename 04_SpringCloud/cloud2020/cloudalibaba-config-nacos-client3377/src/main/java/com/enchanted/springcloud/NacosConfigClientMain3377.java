package com.enchanted.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: NacosConfigClientMain3377
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud
 * @Author Enchanted
 * @Date 2023/12/4 18:11
 * @Version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377
{
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class, args);
    }
}
