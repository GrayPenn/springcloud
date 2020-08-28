package com.young.springcloud.service.impl;

import com.young.springcloud.dao.PaymentDao;
import com.young.springcloud.entities.Payment;
import com.young.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/28 2:04 下午
 * @author: pgy
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }



}
