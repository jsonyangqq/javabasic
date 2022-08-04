package com.interview.javabasic.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author json.yang
 * @Description
 * @Date 2020-05-26
 */
public class StringTest {

    public static void main(String[] args) {
        String hwNumber = "20201203253655411698";
        String substring = hwNumber.substring(hwNumber.length()-7);
        System.out.println(substring);
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now());
        System.out.println(format);
    }

}