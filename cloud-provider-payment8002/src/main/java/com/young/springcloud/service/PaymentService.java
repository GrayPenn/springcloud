package com.young.springcloud.service;

import com.young.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/28 2:04 下午
 * @author: pgy
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);



}
