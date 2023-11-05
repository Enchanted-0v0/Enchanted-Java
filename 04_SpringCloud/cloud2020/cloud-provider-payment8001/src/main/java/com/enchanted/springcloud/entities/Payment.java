package com.enchanted.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Payment
 * @Description: TODO: 实体类Payment
 * @PackageName:com.enchanted.springcloud.entities
 * @Author Enchanted
 * @Date 2023/11/5 14:27
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
