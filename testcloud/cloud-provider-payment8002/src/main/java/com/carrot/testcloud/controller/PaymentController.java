package com.carrot.testcloud.controller;

import com.carrot.testcloud.entities.CommonResult;
import com.carrot.testcloud.entities.Payment;
import com.carrot.testcloud.service.PaymentSerice;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author carrot
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentSerice paymentSerice;

    @Value("${server.port}")
    private  String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentSerice.create(payment);
        log.info("************插入结果："+result);
        if(result>0){
            return  new CommonResult(200,"插入数据成功"+serverPort,result);
        }else {
            return  new CommonResult(444,"插入数据失败"+serverPort,null);
        }
    }

    @GetMapping (value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment payment=paymentSerice.getPaymentById(id);
        log.info("************查询结果："+payment);
        if(payment!=null){
            return  new CommonResult(200,"查询数据成功"+serverPort,payment);
        }else {
            return  new CommonResult(444,"查询数据失败"+serverPort+id,null);
        }
    }
}
