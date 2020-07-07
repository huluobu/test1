package com.carrot.testcloud.exception;

import com.carrot.testcloud.exception.common.BaseException;
import com.carrot.testcloud.exception.common.IResponseEnum;


/**
 * 第三方 调用时，发生的异常信息。 这里的第三方指的是 其他公司的接口
 *
 * @Author: seowen
 * @Date: 2020/6/17 10:30
 * @Version 1.0
 */
public class ThirdException  extends BaseException {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param responseEnum  异常枚举对象
     */
    public ThirdException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    /**
     *
     * @param responseEnum 异常枚举对象
     * @param cause  异常cause
     */
    public ThirdException(IResponseEnum responseEnum,Throwable cause) {
        super(responseEnum,cause);
    }

    /**
     *
     * @param responseEnum  异常枚举对象
     * @param args  占位符参数
     */
    public ThirdException(IResponseEnum responseEnum, Object[] args) {
        super(responseEnum,args);
    }

    /**
     *
     * @param responseEnum    异常枚举对象
     * @param args  占位符参数
     * @param cause  异常cause
     */
    public ThirdException(IResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum,args,cause);
    }
}
