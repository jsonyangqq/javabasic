package com.interview.javabasic.time;

import java.time.*;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @author json.yang
 * @Description java8中操作时间
 * 主要新增了3个类  LocalDateTime、LocalDate、LocalTime  （且都是线程安全的）
 * @Date 2019-10-08
 */
public class Java8Operation {

    public static void main(String[] args) {
        System.out.println("-------------------  java8中获取时间  -------------------");
        getDate();
        System.out.println("-------------------  java8中获取时间戳  -------------------");
        getTimeStamp();
        System.out.println("-------------------  java8中格式化时间  -------------------");
        timeFormat();
        System.out.println("-------------------  java8中字符串转换时间  -------------------");
        timeCovert();
        System.out.println("-------------------  java8中求此刻昨天时间  -------------------");
        getYesterdayTime();
        System.out.println("-------------------  java8中获取本月最后一天时间  -------------------");
        getLastMonth();
        System.out.println("-------------------  java8中计算二个时间的相隔时间  -------------------");
        durationTime();
        System.out.println("-------------------  java8中计算二个时间的相隔日期  -------------------");
        durationPeriodDate();
        System.out.println("-------------------  java8中计算二个时间的相隔年数  -------------------");
        LocalDate d1 = LocalDate.of(2019,9,9);
        LocalDate d2 = LocalDate.now();
        durationPeriodYear(d1,d2);

        System.out.println(LocalDate.now().getMonthValue());

    }

    /**
     * java8中获取时间
     */
    public static void getDate(){
        //获取日期
        LocalDate localDate = LocalDate.now();  //output 2019-10-08
        System.out.println(localDate);
        //获取时间
        LocalTime localTime = LocalTime.now();  //output 09:56:04.456
        System.out.println(localTime);
        //获取日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();  //output 2019-10-08T09:56:04.457
        System.out.println(localDateTime);
    }

    /**
     * java8中获取时间戳
     */
    public static void getTimeStamp(){
        long milli = Instant.now().toEpochMilli();//获取时间戳、精确到毫秒
        long epochSecond = Instant.now().getEpochSecond();//获取时间戳、精确到秒
        System.out.println(milli);
        System.out.println(epochSecond);
    }

    /**
     * java8中时间格式化
     */
    public static void timeFormat(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeFormat = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(timeFormat);
        //时间格式化第二种方式
        String timeFormat2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeFormat2);
    }

    /**
     * java8中的时间转换
     */
    public static void timeCovert(){
        String timeStr = "2019-10-10";
        LocalDate dateTime = LocalDate.parse(timeStr,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("timeCovert=>"+dateTime);
    }

    /**
     * java8获取昨天此刻的时间
     */
    public static void getYesterdayTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime yesterday = localDateTime.plusDays(-1);
        System.out.println(yesterday);
    }

    /**
     * java8中获取本月最后一天时间
     */
    public static void getLastMonth(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));
    }


    /**
     * java8计算二个时间的相隔时间
     */
    public static void durationTime(){
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = dt1.plusSeconds(60);
        Duration duration = Duration.between(dt1, dt2);
        System.out.println(duration.getSeconds()+"秒");  // duration.getSeconds（）表示以秒钟为单位
    }

    /**
     * java8计算二个日期的相隔日期
     */
    public static void durationPeriodDate(){
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = d1.plusDays(83);
        System.out.println(d1);
        System.out.println(d2);
        Period period = Period.between(d1, d2);
        System.out.println(period.getDays()+"天");
    }

    public static void durationPeriodYear(LocalDate d1, LocalDate d2) {
        System.out.println(d1);
        System.out.println(d2);
        Period between = Period.between(d1, d2);
        System.out.println("二个时间相隔年数为："+between.getYears());

    }





}