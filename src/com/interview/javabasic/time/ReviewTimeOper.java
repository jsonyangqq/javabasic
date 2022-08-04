package com.interview.javabasic.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * @author json.yang
 * @Description 回顾时间操作
 * @Date 2019-10-10
 */
public class ReviewTimeOper {


    public static void main(String[] args) {
        getTimestampe();
    }

    /**
     * 获取当前时间的时间戳有以下几种方式
     */
    public static void getTimestampe(){
        //方式1
        long method1 = System.currentTimeMillis();
        System.out.println(method1);
        //方式2
        Date date = new Date();
        System.out.println(date.getTime());
        //方式3
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime().getTime());
        //方式4
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        //方式5
        Instant now = Instant.now();
        System.out.println(now.toEpochMilli());
    }


}