package com.carrot.testcloud.exception.common;


/**
 * @Author carrot
 * @Description
 * @Date 2020/6/29 9:39
 **/


import java.io.Serializable;
public interface IResponseEnum extends Serializable {

    String getCode();
    String getMessage();
    default String asString(){
        return "(\""+getCode()+"\",\""+getMessage()+"\")";
    }
}
