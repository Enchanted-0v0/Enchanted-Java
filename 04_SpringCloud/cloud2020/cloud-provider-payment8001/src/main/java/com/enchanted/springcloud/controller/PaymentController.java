package com.enchanted.springcloud.controller;

import com.enchanted.springcloud.entities.CommonResult;
import com.enchanted.springcloud.entities.Payment;
import com.enchanted.springcloud.service.PaymentService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果：" + result);
        if(result > 0) {
            return new CommonResult(200, "Insert Success!, serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "Insert Failed!", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果：" + payment);
        if(payment != null) {
            return new CommonResult(200, "Query Success!, serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "Query Failed! No ID", null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: "+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

}
