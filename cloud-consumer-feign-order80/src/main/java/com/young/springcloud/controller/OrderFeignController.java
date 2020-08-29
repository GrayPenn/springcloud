package com.young.springcloud.controller;

import com.young.springcloud.entities.CommonResult;
import com.young.springcloud.entities.Payment;
import com.young.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/29 9:45 下午
 * @author: pgy
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    private final PaymentFeignService paymentFeignService;

    public OrderFeignController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id ){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //TimeUnit.SECONDS.sleep(3);
        //OpenFeign客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}