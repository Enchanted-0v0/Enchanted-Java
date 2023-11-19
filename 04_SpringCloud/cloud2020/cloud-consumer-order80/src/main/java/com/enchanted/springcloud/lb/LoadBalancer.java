package com.enchanted.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName: LoadBalancer
 * @Description: TODO
 * @PackageName:com.enchanted.springcloud.lb
 * @Author Enchanted
 * @Date 2023/11/19 09:12
 * @Version 1.0
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
