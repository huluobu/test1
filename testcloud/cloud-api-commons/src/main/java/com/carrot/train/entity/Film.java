package com.carrot.train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: carrot
 * @Date: 2020/10/5 9:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    private Integer id;
    private String filmname;
    private String filmtype;
    private String filminfo;
    private BigDecimal filmprice;
    private Integer sales;
    private String imgpath = "static/img/logo2.jpg";
    private String status;


}
