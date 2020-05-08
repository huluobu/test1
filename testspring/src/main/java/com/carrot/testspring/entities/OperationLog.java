package com.carrot.testspring.entities;


import lombok.Data;

import java.util.Date;

/**
 * @Author carrot
 * @Description 操作记录的对象
 * @Date 2020/5/6 15:15
 **/
@Data
public class OperationLog {

    private  String userid;
    private Date creatime;
    private String ip;
    private String method;
    private String operModul;
    private String operType;
    private String operDesc;

    @Override
    public String toString() {
        return "OperationLog{" +
                "userid='" + userid + '\'' +
                ", creatime=" + creatime +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                ", operModul='" + operModul + '\'' +
                ", operType='" + operType + '\'' +
                ", operDesc='" + operDesc + '\'' +
                '}';
    }
}
