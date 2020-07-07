package com.carrot.testcloud.exception.enums;


import com.carrot.testcloud.exception.asserts.CommonExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author: seowen
 * @Date: 2020/6/16 18:39
 * @Version 1.0
 */
public interface CommonExceptionEnum extends Serializable {

    @Getter
    @AllArgsConstructor
    enum Exception implements CommonExceptionAssert {
        //双单引号 占位符，可以展示 单引号
        ENUM_PATTERN_IS_ILLEGAL("C_E_1000","异常枚举 ''{0}'' 占位符不合法.");

        private String code;
        /**
         * 返回消息
         */
        private String message;
    }

    @Getter
    @AllArgsConstructor
    enum BasePojo implements CommonExceptionAssert {
        BASE_PO_IS_NULL("C_BP_1000","初始化的BasePO对象为 null"),
        BASE_DTO_IS_NULL("C_BP_1001","初始化的BaseDTO对象为 null");
        private String code;
        /**
         * 返回消息
         */
        private String message;
    }

    @Getter
    @AllArgsConstructor
    enum Redis implements CommonExceptionAssert {
        REDIS_PREFIX_IS_NULL("C_R_1000","prefix is null");

        private String code;
        /**
         * 返回消息
         */
        private String message;
    }

    @Getter
    @AllArgsConstructor
    enum Api implements CommonExceptionAssert {
        API_IDEMPOTENT_IS_EXIST("C_A_1000","幂等因子 ''{0}''，已经存在");

        private String code;
        /**
         * 返回消息
         */
        private String message;
    }
}