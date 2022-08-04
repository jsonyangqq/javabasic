package com.interview.javabasic.time;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author json.yang
 * @Description java8之前获取时间
 * @Date 2019-10-08
 */
public class BeforeJava8 {


    public static void main(String[] args) throws ParseException {
        System.out.println("-------------------  获取时间  -------------------");
        getDate();
        System.out.println("-------------------  获取时间戳  -------------------");
        getTimeStamp();
        System.out.println("-------------------  获取格式化后的时间  -------------------");
        formatDateTime();
        timeConvert();
        System.out.println("-------------------  获取昨天此刻的时间  -------------------");
        geYesterdaytMomentTime();
        System.out.println("-------------------  java8之前获取本月最后一天时间  -------------------");
        getLastMonth();
    }

    /**
     * java8之前获取时间
     */
    public static void getDate(){
        Date date = new Date();
        System.out.println(date);
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(time);
    }

    /**
     * java8之前获取时间戳
     */
    public static void getTimeStamp(){
        long ts = System.currentTimeMillis();
        System.out.println(ts);
        long ts2 = new Date().getTime();
        System.out.println(ts2);
        long ts3 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ts3);
    }

    /**
     * java8之前获取格式化后的时间
     * 在多线程下 SimpleDateFormat 是非线程安全的，因此在使用 SimpleDateFormat 时要注意这个问题。在多线程下，如果使用不当，可能会造成结果不对或内存泄漏等问题。
     */
    public static void formatDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("-------------------  获取星期几  -------------------");
        String week = new SimpleDateFormat("E").format(new Date());
        System.out.println(week);
        System.out.println("-------------------  获取当前时区  -------------------");
        String timeZone = new SimpleDateFormat("Z").format(new Date());
        System.out.println(timeZone);
    }

    /**
     * java8之前的时间转换
     */
    public static void timeConvert() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String 转 Date
        String str = "2019-10-10 10:10:10";
        System.out.println(sf.parse(str));
        //时间戳的字符串 转 Date
        String tsString = "1556788591462";
        // import java.sql
        Timestamp ts = new Timestamp(Long.parseLong(tsString)); // 时间戳的字符串转 Date
        System.out.println(sf.format(ts));
    }

    /**
     * 获取昨天此刻的时间
     */
    public static void geYesterdaytMomentTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTime());
    }

    /**
     * java8之前获取本月最后一条时间
     */
    public static void getLastMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getTime());
    }


}