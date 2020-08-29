package com.young.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/29 8:32 下午
 * @author: pgy
 **/
public interface LoadBalancer {


    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
