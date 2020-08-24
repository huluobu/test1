package com.carrot.testcloud.entities;


import lombok.Data;

import java.util.Date;

/**
 * @Author carrot
 * @Description 操作记录的对象
 * @Date 2020/5/6 15:15
 **/
@Data
public class OperationLog {

    private  String id;
    private Date creatime;
    private String operationUnit;
    private String method;
    private String userId;
    private Long runTime;
    private String returnValue;

    @Override
    public String toString() {
        return "OperationLog{" +
                "id='" + id + '\'' +
                ", creatime=" + creatime +
                ", operationUnit='" + operationUnit + '\'' +
                ", method='" + method + '\'' +
                ", userId='" + userId + '\'' +
                ", runTime=" + runTime +
                ", returnValue='" + returnValue + '\'' +
                '}';
    }
}
