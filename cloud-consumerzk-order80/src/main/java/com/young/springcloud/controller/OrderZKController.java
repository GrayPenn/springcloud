package com.young.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/29 2:39 下午
 * @author: pgy
 **/
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderZKController {
    private static final String INVOKE_URL = "http://cloud-provider-payment";

    private final RestTemplate restTemplate;

    public OrderZKController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping(value = "/payment/zk")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return result;
    }
}
