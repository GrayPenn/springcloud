package com.young.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/28 3:49 下午
 * @author: pgy
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //赋予了 RestTemplate 负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
