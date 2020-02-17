package com.carrot.testspring.config;


import com.carrot.testspring.service.Helloservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {
    @Bean
    public Helloservice helloservice(){
        return new Helloservice();
    }
}
