package com.enchanted.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.controller
 * @Author Enchanted
 * @Date 2023/11/17 01:06
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk()
    {
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}