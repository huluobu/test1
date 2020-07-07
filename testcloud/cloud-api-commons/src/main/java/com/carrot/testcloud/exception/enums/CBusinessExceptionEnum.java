package com.carrot.testcloud.exception.enums;


import com.carrot.testcloud.exception.asserts.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author: seowen
 * @Date: 2020/6/16 18:39
 * @Version 1.0
 */
public interface CBusinessExceptionEnum extends Serializable {

    @Getter
    @AllArgsConstructor
    enum BasePojo implements BusinessExceptionAssert {
        BASE_PO_IS_NULL("B_BP_1000","操作的PO对象 ''{0}'' is null"),
        BASE_DTO_IS_NULL("B_BP_1001","操作的DTO对象 ''{0}'' is null"),
        BASE_BO_IS_NULL("B_BP_1002","操作的BO对象 ''{0}'' is null"),
        BASE_VO_IS_NULL("B_BP_1003","操作的VO对象 ''{0}'' is null");
        private String code;
        /**
         * 返回消息
         */
        private String message;
    }

}