package com.carrot.testcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * create by: carrot
 * classname: ApplicationContextConfig
 * description: use to 容器配置
 * create time: 2020/4/20 9:30
 */

@Configuration
public class ApplicationContextConfig {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        /**
         * create by: carrot
         * description: 用于consumer to payment communcation
         * create time: 2020/4/20 9:25
         * @return org.springframework.web.client.RestTemplate
         */
        return new RestTemplate();

    }
}
