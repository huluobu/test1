package com.carrot.testcloud.exception.asserts;


import com.carrot.testcloud.exception.CommonException;
import com.carrot.testcloud.exception.common.Assert;
import com.carrot.testcloud.exception.common.BaseException;
import com.carrot.testcloud.exception.common.IResponseEnum;

/**
 * @Author: seowen
 * @Date: 2020/6/11 20:25
 * @Version 1.0
 */
public interface CommonExceptionAssert extends IResponseEnum, Assert {

    /**
     * 创建异常
     * @param param  异常对象
     * @return
     */
    @Override
    default BaseException newException(Object param){
        param.getClass().getName();
        return new CommonException(this);
    }


    /**
     * 创建异常
     * @param param 异常对象
     * @param args  占位符信息
     * @return
     */
    @Override
    default BaseException newException(Object param,Object... args){
        return new CommonException(this,args);
    }
}
