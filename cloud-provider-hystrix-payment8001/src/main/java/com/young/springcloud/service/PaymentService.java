package com.young.springcloud.service;

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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
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


}
