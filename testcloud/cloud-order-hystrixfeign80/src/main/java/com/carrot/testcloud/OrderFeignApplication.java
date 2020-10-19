package com.carrot.testcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author: carrot
 * @Date: 2020/10/19 16:02
 * @Description:
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class OrderFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication.class,args);}
}
