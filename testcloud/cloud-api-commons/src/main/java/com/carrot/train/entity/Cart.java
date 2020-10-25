package com.carrot.train.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/9 15:38
 * @Description:
 */
public class Cart {
    private Integer totalcount=0;
    private BigDecimal totalprice;
    private Map<String, CartItem> items = new HashMap<String, CartItem>();

    public void addItem(CartItem cartItem) {
        String mapid = cartItem.getFilmid().toString() + cartItem.getMatchid();
        if (items.containsKey(mapid)) {
            System.out.println("该商品已经添加");
        } else {
            items.put(mapid,cartItem);
            totalcount = totalcount + 1;
            totalprice = totalprice.add(cartItem.getPrice());

        }
    }

    public void deleteItem() {

    }
}
