package com.young.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/30 8:40 上午
 * @author: pgy
 **/
@Service
public class PaymentService {


    /**
     * 正常访问，肯定 ok 的
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){

        return "线程池：  "+Thread.currentThread().getName()+"     paymentInfo_OK,id:  "+id+"\t" +"O(∩_∩)O~";
    }



    /**
     * 正常访问，肯定 ok 的
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")//@link = HystrixCommandProperties
    })
    public String paymentInfo_TimeOut(Integer id){
        //int age = 10/0;
        int timeNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName()+
                "     paymentInfo_TimeOut,id:  "+id+"\t" +"O(∩_∩)O~"
                +"   耗时"+timeNumber+"秒钟";
    }


    public String paymentInfoTimeOutHandler(Integer id){
        System.out.println(id);
        return "线程池：  "+Thread.currentThread().getName()+
                "     paymentInfo_TimeOut,id:  "+id+"\t" +"ಥ_ಥ";
    }


    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
            //10秒内，10次请求的失败率达到百分之60后，跳闸限电
    })
    public String paymentCircuitBreaker( Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
