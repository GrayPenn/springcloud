package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by IntelliJ IDEA.
 *
 * @date: 2020/9/18 4:43 下午
 * @author: pgy
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamMQApplication8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQApplication8803.class,args);
    }
}
