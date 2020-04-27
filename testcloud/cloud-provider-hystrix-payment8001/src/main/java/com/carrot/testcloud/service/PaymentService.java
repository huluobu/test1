package com.carrot.testcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * create by: carrot
 * classname: PaymentService
 * description: use to
 * create time: 2020/4/27 15:51
 * @author carrot
 */
@Service
public class PaymentService {
    /**
     * create by: carrot
     * description: 用于正常访问
     * create time: 2020/4/27 15:18
     * @return
     */
    public String paymentInfo_ok(Integer id){
        return "线程池 ："+Thread.currentThread().getName()+"paymentInfo_ok, id is；"+id;
    }

    public String paymentInfo_timeout(Integer id) {
        int time=3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 ："+Thread.currentThread().getName()+"paymentInfo_timeout, id is；"+id;
    }
}
