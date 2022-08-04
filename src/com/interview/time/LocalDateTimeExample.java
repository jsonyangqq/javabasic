package com.interview.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-04-21 10:16
 */
public class LocalDateTimeExample {

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.parse("2021-09-02 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime time1 = time.plusDays(120);
        System.out.println(time1);

    }

}