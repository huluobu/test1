package com.carrot.testspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@Conditional()
//@EnableAutoConfiguration
/*@ImportResource(locations = {"classpath:beans.xml"})*/
@SpringBootApplication
public class TestspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestspringApplication.class, args);
    }

}
