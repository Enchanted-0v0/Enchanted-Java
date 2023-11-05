package com.enchanted.springcloud.controller;

import com.enchanted.springcloud.entities.CommonResult;
import com.enchanted.springcloud.entities.Payment;
import com.enchanted.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.controller
 * @Author Enchanted
 * @Date 2023/11/5 14:36
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果：" + result);
        if(result > 0) {
            return new CommonResult(200, "Insert Success!", result);
        } else {
            return new CommonResult(444, "Insert Failed!", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果：" + payment);
        if(payment != null) {
            return new CommonResult(200, "Query Success!", payment);
        } else {
            return new CommonResult(444, "Query Failed! No ID", null);
        }
    }
}
