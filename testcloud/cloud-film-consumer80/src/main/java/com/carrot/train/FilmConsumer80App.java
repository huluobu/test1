package com.carrot.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author: carrot
 * @Date: 2020/10/24 20:51
 */
@SpringBootApplication
@EnableFeignClients
public class FilmConsumer80App {
    public static void main(String[] args) {
        SpringApplication.run(FilmConsumer80App.class);
    }
}
