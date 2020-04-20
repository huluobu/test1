package com.carrot.testcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by: carrot
 * classname: OrderApplication
 * description: use to start up
 * create time: 2020/4/20 9:38
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class OrderApplication {
    public static void main(String[] args) {
     SpringApplication.run(OrderApplication.class,args);}
}
