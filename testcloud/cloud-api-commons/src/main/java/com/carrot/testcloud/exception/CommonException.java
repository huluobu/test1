package com.carrot.testcloud.exception;

import com.carrot.testcloud.exception.common.BaseException;
import com.carrot.testcloud.exception.common.IResponseEnum;


/**
 * 业务异常，指 业务处理上的异常，
 *
 * @Author: seowen
 * @Date: 2020/6/11 20:15
 * @Version 1.0
 */
public class CommonException extends BaseException {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param responseEnum  异常枚举对象
     */
    public CommonException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    /**
     *
     * @param responseEnum 异常枚举对象
     * @param cause  异常cause
     */
    public CommonException(IResponseEnum responseEnum, Throwable cause) {
        super(responseEnum,cause);
    }

    /**
     *
     * @param responseEnum  异常枚举对象
     * @param args  占位符参数
     */
    public CommonException(IResponseEnum responseEnum, Object[] args) {
        super(responseEnum,args);
    }

    /**
     *
     * @param responseEnum    异常枚举对象
     * @param args  占位符参数
     * @param cause  异常cause
     */
    public CommonException(IResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum,args,cause);
    }
}
