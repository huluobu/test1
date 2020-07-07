package com.carrot.testcloud.exception.enums;


import com.carrot.testcloud.exception.asserts.ApiExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * Api异常
 *
 * @Author: seowen
 * @Date: 2020/6/16 18:39
 * @Version 1.0
 */
public interface ApiExceptionEnum extends Serializable {

    @Getter
    @AllArgsConstructor
    enum HTTP implements ApiExceptionAssert {
        HTTP_BAD_REQUEST("A_H_1000","Api调用失败"),
        HTTP_FAIL("A_H_1001","Api调用失败，状态为{0}");

        private String code;
        /**
         * 返回消息
         */
        private String message;


    }
}