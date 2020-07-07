package com.carrot.testcloud.entities;


import com.carrot.testcloud.exception.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author carrot
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data=null;
    }

    public CommonResult(ResponseEnum responseEnum) {
        this.code = Integer.valueOf(responseEnum.getCode()).intValue();
        this.message = responseEnum.getMessage();
        this.data=null;
    }

    public CommonResult(String code, String message) {
        this.code = Integer.valueOf(code).intValue();
        this.message = message;
        this.data=null;
    }
}
