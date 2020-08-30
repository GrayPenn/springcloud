package com.young.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/30 8:23 下午
 * @author: pgy
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {

        return "-----PaymentFallbackService fall back-paymentInfoOk ,o(╥﹏╥)o";

    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoTimeOut ,o(╥﹏╥)o";
    }
}
