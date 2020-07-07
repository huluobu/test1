package com.carrot.testcloud.exception;


import com.carrot.testcloud.exception.common.BaseException;
import com.carrot.testcloud.exception.common.IResponseEnum;

/**
 * Api异常信息，值 模块之间调用 产生的异常信息
 *
 * @Author: seowen
 * @Date: 2020/6/17 10:30
 * @Version 1.0
 */
public class ApiException extends BaseException {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param responseEnum  异常枚举对象
     */
    public ApiException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    /**
     *
     * @param responseEnum 异常枚举对象
     * @param cause  异常cause
     */
    public ApiException(IResponseEnum responseEnum, Throwable cause) {
        super(responseEnum,cause);
    }

    /**
     *
     * @param responseEnum  异常枚举对象
     * @param args  占位符参数
     */
    public ApiException(IResponseEnum responseEnum, Object[] args) {
        super(responseEnum,args);
    }

    /**
     *
     * @param responseEnum    异常枚举对象
     * @param args  占位符参数
     * @param cause  异常cause
     */
    public ApiException(IResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum,args,cause);
    }
}
