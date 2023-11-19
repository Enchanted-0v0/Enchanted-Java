package com.enchanted.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Description: TODO：配置类
 * @PackageName:com.enchanted.springcloud.config
 * @Author Enchanted
 * @Date 2023/11/5 15:19
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    // @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
