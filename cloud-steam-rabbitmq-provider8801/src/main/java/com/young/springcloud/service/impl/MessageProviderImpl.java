package com.young.springcloud.service.impl;

import com.young.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/9/15 3:25 下午
 * @author: pgy
 **/
@EnableBinding(Source.class)//定义消息的推送管道，类似 output
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******************serial:"+serial);
        return null;
    }







}
