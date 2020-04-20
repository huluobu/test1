package com.carrot.testcloud.service;

import com.carrot.testcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author carrot
 */
public interface PaymentSerice {
    public  int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
