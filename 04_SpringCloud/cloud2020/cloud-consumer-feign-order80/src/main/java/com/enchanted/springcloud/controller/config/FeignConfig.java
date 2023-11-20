package com.enchanted.springcloud.controller.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FeignConfig
 * @Description: TODO: 日志配置
 * @PackageName:com.enchanted.springcloud.controller.config
 * @Author Enchanted
 * @Date 2023/11/20 10:52
 * @Version 1.0
 */
@Configuration
public class FeignConfig
{
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
