package com.young.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/9/1 10:15 上午
 * @author: pgy
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication3344.class,args);
    }
}
