package com.interview.nulljudge;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-07-09 14:39
 */
public class OptionalTest {

    public Optional<Order> getByOrderId(Long orderId) {
        return Optional.ofNullable(doGetByOrderId(orderId));
    }

    private Order doGetByOrderId(Long orderId) {
        Order order = new Order();
        order.setOrderId(123L);
        order.setUserName("张三");
        order.setPayAmount(new BigDecimal(100));
        if(Optional.ofNullable(orderId).isPresent()) {
            if(orderId.equals(order.getOrderId())) {
                return order;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        Optional<Order> byOrderId = optionalTest.getByOrderId(null);
        System.out.println(byOrderId);
    }


}