package com.enchanted.springcloud.controller;

import com.enchanted.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: SendMessageController
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.controller
 * @Author Enchanted
 * @Date 2023/12/1 15:24
 * @Version 1.0
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}

