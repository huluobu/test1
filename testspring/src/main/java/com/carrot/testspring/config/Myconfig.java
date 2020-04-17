package com.carrot.testspring.config;


import com.carrot.testspring.entities.User;
import com.carrot.testspring.service.Helloservice;
import com.carrot.testspring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

@Configuration
public class Myconfig {
    @Bean
    public Helloservice helloservice(){
        return new Helloservice();
    }


}
