package com.carrot.testcloud.controller;

import com.carrot.testcloud.entities.CommonResult;
import com.carrot.testcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * create by: carrot
 * classname: OrderController
 * description: use to control order service
 * create time: 2020/4/20 9:31
 */
@RestController
@Slf4j
public class OrderController {

//    public static  final  String PAYMENT_URL="http://localhost:8001";
    public static  final  String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> createConsumerPayment(Payment payment){
        log.info("创建payment"+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getConsumerPayment(@PathVariable("id") Long id){
        log.info("查询payment"+id);
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
