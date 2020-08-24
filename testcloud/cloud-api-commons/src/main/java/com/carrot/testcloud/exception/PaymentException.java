package com.carrot.testcloud.exception;


import com.carrot.testcloud.exception.common.BaseException;
import com.carrot.testcloud.exception.common.IResponseEnum;

/**
 * @Author: carrot
 * @Date: 2020/6/29 10:03
 * @Description:
 */
public class PaymentException extends BaseException {
    private static final long serialVersionUID = 1L;


    /**
     * @deprecated 订单异常的处理方法的构造
     * @author carrot
     * @date 2020/6/29
     * @param responseEnum
     */
    public PaymentException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    /**
     * @deprecated 订单异常的处理方法的构造
     * @author carrot
     * @date 2020/6/29
     * @param responseEnum
     * @param cause
     */
    public PaymentException(IResponseEnum responseEnum,Throwable cause) {
        super(responseEnum,cause);
    }

    public PaymentException(IResponseEnum responseEnum, Object[] args) {
        super(responseEnum,args);
    }

    public PaymentException(IResponseEnum responseEnum, Object[] args, Throwable cause) { super(responseEnum,args,cause);}
}
