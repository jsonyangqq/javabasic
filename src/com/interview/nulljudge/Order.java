package com.interview.nulljudge;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jason.yang
 * @Description 订单类
 * @Date 2021-07-09 14:40
 */
@Data
public class Order {

    private Long orderId;

    private String userName;

    private BigDecimal payAmount;

}