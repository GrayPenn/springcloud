package com.young.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 *也可以在启动类中排除excludeFilters
 *
 * @date: 2020/8/29 8:05 下午
 * @author: pgy
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule()
    {   //定义为随机
        return new RandomRule();
    }


}
