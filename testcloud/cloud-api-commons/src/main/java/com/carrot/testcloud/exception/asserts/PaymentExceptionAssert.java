package com.carrot.testcloud.exception.asserts;


import com.carrot.testcloud.exception.PaymentException;
import com.carrot.testcloud.exception.common.Assert;
import com.carrot.testcloud.exception.common.BaseException;
import com.carrot.testcloud.exception.common.IResponseEnum;

/**
 * @Author: carrot
 * @Date: 2020/6/29 10:18
 * @Description:
 */
public interface PaymentExceptionAssert extends IResponseEnum, Assert {
    /**
     * @deprecated 
     * @author carrot
     * @date 2020/7/6
     * @param: Object
     * @return 
     **/
    @Override
    default BaseException newException(Object param){
/*        param.getClass().getName();*/
        return new PaymentException(this);
    }

    /**
     * @deprecated 
     * @author carrot
     * @date 2020/7/6
     * @param: null 
     * @return
     **/
    @Override
    default PaymentException newException(Object param, Object... args){
        return new PaymentException(this,args);
    }
}
