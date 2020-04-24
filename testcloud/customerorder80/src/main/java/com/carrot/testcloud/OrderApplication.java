package com.carrot.testcloud;

import com.carrot.robin.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * create by: carrot
 * classname: OrderApplication
 * description: use to start up
 * create time: 2020/4/20 9:38
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT",configuration = MyRule.class)
public class OrderApplication {
    public static void main(String[] args) {
     SpringApplication.run(OrderApplication.class,args);}
}
