package com.enchanted.springcloud.dao;

import com.enchanted.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.dao
 * @Author Enchanted
 * @Date 2023/11/5 14:28
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
