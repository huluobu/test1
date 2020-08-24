package com.carrot.testcloud.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: carrot
 * @Date: 2020/8/24 10:37
 * @Description:
 */
public class Consumer implements Serializable {
    private  long id;
    private String address;
    private  String iden;
	private  String age;
	private Date birth;
	private  double weight;
}
