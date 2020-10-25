package com.carrot.train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: carrot
 * @Date: 2020/10/9 15:25
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Integer filmid;
    private Integer matchid;
    private String seatnum;
    private BigDecimal price;
}
