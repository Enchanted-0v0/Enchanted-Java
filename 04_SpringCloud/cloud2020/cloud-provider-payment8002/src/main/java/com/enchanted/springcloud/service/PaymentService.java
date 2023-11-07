package com.enchanted.springcloud.service;

import com.enchanted.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentService
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.service
 * @Author Enchanted
 * @Date 2023/11/5 14:32
 * @Version 1.0
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}