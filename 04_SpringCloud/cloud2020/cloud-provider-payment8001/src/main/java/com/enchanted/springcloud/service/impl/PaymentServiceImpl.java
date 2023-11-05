package com.enchanted.springcloud.service.impl;

import com.enchanted.springcloud.dao.PaymentDao;
import com.enchanted.springcloud.entities.Payment;
import com.enchanted.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @ClassName: PaymentServiceImpl
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.service.impl
 * @Author Enchanted
 * @Date 2023/11/5 14:33
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}




