package com.enchanted.springcloud.utils;

import java.time.ZonedDateTime;

/**
 * @ClassName: T2
 * @Description: TODO: 获得当前时间戳
 * @PackageName:com.enchanted.springcloud.utils
 * @Author Enchanted
 * @Date 2023/11/24 17:08
 * @Version 1.0
 */
public class T2
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

       // 2023-11-24T17:09:14.232+08:00[Asia/Shanghai]
    }
}
