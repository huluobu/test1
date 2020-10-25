package com.carrot.train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: carrot
 * @Date: 2020/10/5 10:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmOrder {
    private Integer id;
    private Integer matchid;
    private Integer userid;
    private Date ordertime;
    private Date updatatime;
    private String seatnum;
    private BigDecimal totalprice;
    private BigDecimal price;
    private String status;
}
