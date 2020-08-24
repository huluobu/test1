package com.carrot.testcloud.controller;

import com.carrot.testcloud.entities.CommonResult;
import com.carrot.testcloud.entities.Payment;
import com.carrot.testcloud.exception.PaymentException;
import com.carrot.testcloud.exception.common.BaseException;
import com.carrot.testcloud.exception.enums.ResponseEnum;
import com.carrot.testcloud.service.PaymentSerice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author carrot
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentSerice paymentSerice;

    @Resource
    private DiscoveryClient discoveryClient;

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

        ResponseEnum.PAYMENT_NOT_FOUND.assertNotNull(payment);
        log.info("************查询结果："+payment);
        return  new CommonResult(200,"查询数据成功"+serverPort,payment);

    }

    @ExceptionHandler(value = PaymentException.class)
    @ResponseBody
    public  CommonResult handlePaymentException(BaseException e){
        log.info(e.getMessage(),e);
        return new CommonResult(e.getCode(),e.getMessage());
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("service:"+element);
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for(ServiceInstance instance:instances){
                log.info(instance.getInstanceId()+"*"+instance.getHost()+"*"+instance.getPort()+"*"+instance.getUri());
            }
        }
        return this.discoveryClient;
    }
}
