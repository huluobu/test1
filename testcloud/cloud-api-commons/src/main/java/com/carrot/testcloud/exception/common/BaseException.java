package com.carrot.testcloud.exception.common;

import com.carrot.testcloud.exception.enums.CommonExceptionEnum;
import lombok.Data;
import java.text.MessageFormat;

/**
 * @Author: carrot
 * @Date: 2020/6/29 10:09
 * @Description:
 */
@Data
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private String code;
    /**
     * 枚举对象默认的 异常信息描述
     */
    private String message;

    /**
     *
     * @param responseEnum  异常枚举对象
     */
    public BaseException(IResponseEnum responseEnum) {
        super(responseEnum.getCode());
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    /**
     *
     * @param responseEnum 异常枚举对象
     * @param cause  异常cause
     */
    public BaseException(IResponseEnum responseEnum,Throwable cause) {
        super(responseEnum.getCode(),cause);
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }



    /**
     *
     * @param responseEnum  异常枚举对象
     * @param args  占位符参数
     */
    public BaseException(IResponseEnum responseEnum,Object[] args) {
        super(responseEnum.getCode());
        this.code = responseEnum.getCode();
        try {
            this.message = MessageFormat.format(responseEnum.getMessage(),args);
        }catch (IllegalArgumentException e){
            CommonExceptionEnum.Exception.ENUM_PATTERN_IS_ILLEGAL.assertNotNull(null
                    ,responseEnum+responseEnum.asString());
        }

    }

    /**
     *
     * @param responseEnum    异常枚举对象
     * @param args  占位符参数
     * @param cause  异常cause
     */
    public BaseException(IResponseEnum responseEnum,Object[] args,Throwable cause) {
        super(responseEnum.getCode(), cause);
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        try {
            this.message = MessageFormat.format(responseEnum.getMessage(),args);
        }catch (IllegalArgumentException e){
            CommonExceptionEnum.Exception.ENUM_PATTERN_IS_ILLEGAL.assertNotNull(null
                    ,responseEnum+responseEnum.asString());
        }
    }
}
