package com.young.springcloud.controller;

import com.young.springcloud.entities.CommonResult;
import com.young.springcloud.entities.Payment;
import com.young.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/8/28 2:08 下午
 * @author: pgy
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        }

        return new CommonResult(444, "插入数据库失败", null);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "查询成功serverPort:" + serverPort, payment);
        }

        return new CommonResult(444, "查询失败，查询 id：" + id, null);
    }


    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String url : services){
            log.info("**************service-url:"+url);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        log.info("===========================================");
        for (ServiceInstance instance : instances){
            log.info("**************instance:"+instance.getServiceId()+"  "+instance.getHost()+"  "+instance.getPort()+"  "+instance.getUri());
        }
        return this.discoveryClient;
    }



    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
