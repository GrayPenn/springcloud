package com.young.springcloud.dao;

import com.young.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/28 1:50 下午
 * @author: pgy
 **/
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);



}
