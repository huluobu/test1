package com.carrot.testcloud.service.imp;

import com.carrot.testcloud.dao.PaymentDao;
import com.carrot.testcloud.entities.Payment;
import com.carrot.testcloud.service.PaymentSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentSericeImp implements PaymentSerice {


    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
