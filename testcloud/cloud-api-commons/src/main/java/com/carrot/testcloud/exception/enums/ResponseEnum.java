package com.carrot.testcloud.exception.enums;

import com.carrot.testcloud.exception.asserts.PaymentExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author carrot
 * @Description
 * @Date 2020/6/29 10:23
 **/

@Getter
@AllArgsConstructor
public enum ResponseEnum implements PaymentExceptionAssert {

    BAD_PAYMENT_TYPE("7001", "Bad Pay type."),
    PAYMENT_NOT_FOUND("7002", "Pay not found.");

    private String code;
    private String message;

}
