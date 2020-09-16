package com.young.springcloud.controller;

import com.young.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/9/15 3:35 下午
 * @author: pgy
 **/
@RestController
public class SendMessageController {



    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }





}
