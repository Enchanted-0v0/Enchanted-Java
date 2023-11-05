package com.enchanted.springcloud.config;

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
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
