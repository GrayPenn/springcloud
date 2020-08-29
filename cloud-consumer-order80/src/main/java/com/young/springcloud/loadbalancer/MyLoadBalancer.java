package com.young.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/29 8:47 下午
 * @author: pgy
 **/
@Component
public class MyLoadBalancer implements LoadBalancer {


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            //最大值就是2147483647
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("=============第几次访问，次数next:" + next);
        return next;

    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
