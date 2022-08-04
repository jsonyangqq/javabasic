package com.interview.effective.createanddrop;


import java.time.Instant;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author json.yang
 * @Description 静态工厂常用例子
 * @Date 2020-06-22
 */
public class StaticFactoryExample {

    public static void main(String[] args) {
        Date from = Date.from(Instant.now());
        Set<Rank> faceCards = EnumSet.of(Rank.JACK,Rank.QUEEN,Rank.KING);
    }

}