package com.enchanted.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ReceiveMessageListenerController
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.controller
 * @Author Enchanted
 * @Date 2023/12/1 15:55
 * @Version 1.0
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者2 号,----->接受到的消息: " + message.getPayload() + "\t  port: " + serverPort);
    }
}

