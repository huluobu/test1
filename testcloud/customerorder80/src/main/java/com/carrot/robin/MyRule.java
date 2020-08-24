package com.carrot.robin;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by: carrot
 * classname: MyRule
 * description: use to
 * create time: 2020/4/24 10:01
 */
@Configuration
public class MyRule {

    /**
     * create by: carrot
     * description: 用于自定义规则
     * create time: 2020/4/24 10:02
     * @return robbin rule
     */
    @Bean
    public IRule MyRule(){
        return new MyRobinRule();
    }
}
