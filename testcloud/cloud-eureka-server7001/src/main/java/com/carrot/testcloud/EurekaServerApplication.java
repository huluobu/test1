package com.carrot.testcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**


/**
 * @author     ：mmzs
 * @date       ：Created in 2020/4/20 10:45
 * @description：eureka server start up
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        /**
         * create by: carrot
         * description: 用于主函数
         * create time: 2020/4/20 10:46
         * @return void
         */
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
