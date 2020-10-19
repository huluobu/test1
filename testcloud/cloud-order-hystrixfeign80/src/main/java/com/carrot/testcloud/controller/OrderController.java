package com.carrot.testcloud.controller;

import com.carrot.testcloud.entities.CommonResult;
import com.carrot.testcloud.entities.Payment;
import com.carrot.testcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: carrot
 * @Date: 2020/10/19 16:21
 * @Description:
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer1/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id) {
        return paymentFeignService.getPaymentById(id);
    }

}
