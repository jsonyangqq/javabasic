package com.interview.wide.lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jason.yang
 * @Description 时间字符串排序
 * @Date 2021-08-12 10:10
 */
public class CreateTimeSorted {

    public static void main(String[] args) {

        List<String> createTimeLists = new ArrayList<>();
        createTimeLists.add("2021-01");
        createTimeLists.add("2021-12");
        createTimeLists.add("2021-10");
        createTimeLists.add("2021-08");
        createTimeLists.add("2021-07");
        createTimeLists.add("2021-03");
        createTimeLists.add("2021-05");
        createTimeLists.add("2021-11");
        createTimeLists.add("2021-09");
        createTimeLists.add("2021-04");
        createTimeLists.add("2021-06");
        createTimeLists.add("2021-02");

        List<String> collect = createTimeLists.stream().sorted(Comparator.<String, String>comparing(s1 -> s1).reversed()).collect(Collectors.toList());
        System.out.println(collect);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = df.format(LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN));
        System.out.println(format);
        testSS();
        String date = df.format(LocalDateTime.of(LocalDateTime.now().minusYears(1).plusMonths(1).with(TemporalAdjusters.firstDayOfMonth()).toLocalDate(),LocalTime.MIN));
        System.out.println(date);

    }

    public static String testSS() {
        List<String> createTimeLists = new ArrayList<>();
        createTimeLists.add("2021-01");
        createTimeLists.add("2021-12");
        createTimeLists.add("2021-10");
        createTimeLists.add("2021-08");
        createTimeLists.add("2021-07");
        createTimeLists.add("2021-03");
        createTimeLists.add("2021-05");
        createTimeLists.add("2021-11");
        createTimeLists.add("2021-09");
        createTimeLists.add("2021-04");
        createTimeLists.add("2021-06");
        createTimeLists.add("2021-02");

        List<String> collect = createTimeLists.stream().sorted(Comparator.<String, String>comparing(s1 -> s1)).collect(Collectors.toList());
        System.out.println(collect);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = df.format(LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN));
        System.out.println(format);

        String date = df.format(LocalDateTime.of(LocalDateTime.now().minusYears(1).plusMonths(1).with(TemporalAdjusters.firstDayOfMonth()).toLocalDate(),LocalTime.MIN));
        System.out.println(date);
        return null;
    }

}