package com.carrot.train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: carrot
 * @Date: 2020/10/5 9:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmMatch {
    private Integer id;
    private Integer filmid;
    private String location;
    private String halltype;
    private BigDecimal filmprice;
    private Integer sales;
    private Date begindate;
    private String reseats;
    private String status;

}
