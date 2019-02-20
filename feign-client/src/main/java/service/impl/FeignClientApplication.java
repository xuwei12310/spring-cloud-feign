package service.impl;

import com.example.feign.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import rule.MyRule;

import java.util.Random;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
@RibbonClient(value = "person-service",configuration = FeignClientApplication.class)
@EnableHystrix
public class FeignClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class,args);
    }

    /**
     * 把自定义规则 注册为spring bean
     * @return
     */
    @Bean
    public MyRule getRule(){
        return new MyRule();
    }
}
