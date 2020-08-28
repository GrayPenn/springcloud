package com.young.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by IntelliJ IDEA.
 * User: pgy
 * Date: 2020/8/27
 * Time: 8:28 下午
 **/
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8002 {


    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class,args);
    }

}
