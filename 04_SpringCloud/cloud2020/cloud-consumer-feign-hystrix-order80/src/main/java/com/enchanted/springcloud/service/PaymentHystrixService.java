package com.enchanted.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: PaymentHystrixService
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.service
 * @Author Enchanted
 * @Date 2023/11/21 12:26
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,//
        fallback = PaymentFallbackService.class)//指定PaymentFallbackService类
public interface PaymentHystrixService
{
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}

