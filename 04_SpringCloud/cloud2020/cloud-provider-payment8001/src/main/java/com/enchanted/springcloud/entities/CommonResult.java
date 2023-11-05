package com.enchanted.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CommonResult
 * @Description: TODO：JSON封装体CommonResult
 * @PackageName:com.enchanted.springcloud.entities
 * @Author Enchanted
 * @Date 2023/11/5 14:27
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
