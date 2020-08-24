package com.carrot.testcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by: carrot
 * classname: HystrixApplication
 * description: use to Hystrix app start up
 * create time: 2020/4/27 15:07
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class HystrixPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentApplication.class);
    }
}
