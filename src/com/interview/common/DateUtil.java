package com.interview.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 * @author json.yang
 * @Description 时间插件编写
 * @Date 2019/4/13
 */
public class DateUtil {

    static final String[] datePatters = new String[]{"yyyy-MM-dd", "yyyyMMdd", "dd/MM/yyyy", "MM/dd/yyyy", "yyyy年MM月dd日"};
    static final String[] datetimePatters = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyyMMdd HHmmss", "dd/MM/yyyy HH:mm:ss", "MM/dd/yyyy HH:mm:ss", "yyyy年MM月dd日 HH时mm分ss秒"};

    public DateUtil() {
    }

    public static Date parseDateTryCustomPatters(String date) {
        if (date != null && date.trim().length() > 0) {
            date = date.trim();
            if (date.indexOf("-") != -1) {
                if (date.split("-").length != 3) {
                    return null;
                }
            } else if (date.indexOf("/") != -1 && date.split("/").length != 3) {
                return null;
            }

            SimpleDateFormat formatter = new SimpleDateFormat();
            Date d = null;
            String[] var3 = datePatters;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String patter = var3[var5];

                try {
                    formatter.applyPattern(patter);
                    d = formatter.parse(date);
                    break;
                } catch (ParseException var8) {
                    ;
                } catch (Exception var9) {
                    System.err.println("=================");
                    System.err.println("p:" + patter + ",d:" + date);
                    System.err.println("=================");
                    var9.printStackTrace();
                }
            }

            return d;
        } else {
            return null;
        }
    }

    public static Date parseDatetimeTryCustomPatters(String datetime) {
        if (datetime != null && datetime.trim().length() > 0) {
            datetime = datetime.trim();
            if (datetime.indexOf("-") != -1) {
                if (datetime.split("-").length != 3) {
                    return null;
                }
            } else if (datetime.indexOf("/") != -1 && datetime.split("/").length != 3) {
                return null;
            }

            SimpleDateFormat formatter = new SimpleDateFormat();
            Date d = null;
            String[] var3 = datetimePatters;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String patter = var3[var5];

                try {
                    formatter.applyPattern(patter);
                    d = formatter.parse(datetime);
                    break;
                } catch (ParseException var8) {
                    ;
                } catch (Exception var9) {
                    System.err.println("=================");
                    System.err.println("p:" + patter + ",d:" + datetime);
                    System.err.println("=================");
                    var9.printStackTrace();
                }
            }

            return d;
        } else {
            return null;
        }
    }

    public static String time2CHNStr(long millisecond) {
        if (millisecond <= 0L) {
            return "0秒";
        } else {
            long t = millisecond / 1000L;
            StringBuilder timeStr = new StringBuilder();
            long d = 0L;
            long h = 0L;
            long m = 0L;
            long s = 0L;
            long ms = 0L;
            if (t >= 86400L) {
                d = t / 86400L;
            }

            if (t - d * 24L * 60L * 60L >= 3600L) {
                h = (t - d * 24L * 60L * 60L) / 3600L;
            }

            if (t - d * 24L * 60L * 60L - h * 60L * 60L >= 60L) {
                m = (t - d * 24L * 60L * 60L - h * 60L * 60L) / 60L;
            }

            s = t - d * 24L * 60L * 60L - h * 60L * 60L - m * 60L;
            if (d > 0L) {
                timeStr.append(d).append("天");
            }

            if (d > 0L || h > 0L) {
                timeStr.append(h).append("小时");
            }

            if (d > 0L || h > 0L || m > 0L) {
                timeStr.append(m).append("分");
            }

            if (d > 0L || h > 0L || m > 0L || s > 0L) {
                timeStr.append(s).append("秒");
            }

            ms = millisecond % 1000L;
            if (ms > 0L) {
                timeStr.append(ms).append("毫秒");
            }

            return timeStr.toString();
        }
    }

    public static String format(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat();
            formatter.applyPattern("yyyy-MM-dd HH:mm:ss");
            return formatter.format(date);
        }
    }

    public static int getBetweenDays1(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(d1);
            c2.setTime(d2);
            if (c1.after(c2)) {
                c2.setTime(d1);
                c1.setTime(d2);
            }

            int betweenYears = c2.get(1) - c1.get(1);
            int betweenDays = c2.get(6) - c1.get(6);

            for(int i = 0; i < betweenYears; ++i) {
                c1.set(1, c1.get(1) + 1);
                betweenDays += c1.getMaximum(6);
            }

            return betweenDays;
        } else {
            return -1;
        }
    }


    public static Date parseDate(String date, String patter) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat();
            formatter.setTimeZone(TimeZone.getDefault());
            formatter.applyPattern(patter);

            try {
                return formatter.parse(date);
            } catch (ParseException var4) {
                return null;
            }
        }
    }


    public static String formatLocal(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int yy = calendar.get(1);
        int mm = calendar.get(2) + 1;
        int dd = calendar.get(5);
        int ww = calendar.get(7);
        int hh = calendar.get(11);
        int mi = calendar.get(12);
        int se = calendar.get(13);
        String s = "";
        s = s + Integer.toString(yy) + "年";
        s = s + Integer.toString(mm) + "月";
        s = s + Integer.toString(dd) + "日";
        s = s + " ";
        switch(ww) {
            case 1:
                s = s + "星期日";
                break;
            case 2:
                s = s + "星期一";
                break;
            case 3:
                s = s + "星期二";
                break;
            case 4:
                s = s + "星期三";
                break;
            case 5:
                s = s + "星期四";
                break;
            case 6:
                s = s + "星期五";
                break;
            case 7:
                s = s + "星期六";
                break;
           default: s = s + "星期日";
        }

        s = s + " ";
        s = s + (hh < 10 ? "0" + Integer.toString(hh) : Integer.toString(hh));
        s = s + ":";
        s = s + (mi < 10 ? "0" + Integer.toString(mi) : Integer.toString(mi));
        s = s + ":";
        s = s + (se < 10 ? "0" + Integer.toString(se) : Integer.toString(se));
        return s;
    }

    public static String formatLocal() {
        return formatLocal(new Date());
    }

    private static String adjust(String date) {
        return (date.endsWith(" 00:00:00") || date.endsWith(" 00:00") || date.endsWith(" 00")) && date.length() > 10 ? date.substring(0, 10) : date;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat();
        formatter.setTimeZone(TimeZone.getDefault());
        formatter.applyPattern("yyyy-MM-dd HH:mm:ss");
        formatter.setLenient(false);
        return adjust(formatter.format(date));
    }

    public static String formatDate(Date date, String patter) {
        SimpleDateFormat formatter = new SimpleDateFormat();
        formatter.setTimeZone(TimeZone.getDefault());
        formatter.applyPattern(patter);
        formatter.setLenient(false);
        return adjust(formatter.format(date));
    }

    public static String formatGMTDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat();
        formatter.applyPattern("yyyy-MM-dd HH:mm:ss");
        formatter.setLenient(false);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return adjust(formatter.format(date));
    }

    public static String formatGMTDate(Date date, String patter) {
        SimpleDateFormat formatter = new SimpleDateFormat();
        formatter.applyPattern(patter);
        formatter.setLenient(false);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return adjust(formatter.format(date));
    }


    public static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static String getNow(String pattern) {
        return formatDate(new Date(), pattern);
    }

    public static Date getNow() {
        return new Date();
    }

    public static int getYear() {
        Date now = new Date();
        return getYear(now);
    }

    public static int getYear(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return cale.get(1);
    }

    public static int getMonth() {
        Date now = new Date();
        return getMonth(now);
    }

    public static int getMonth(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return cale.get(2) + 1;
    }

    public static int getQuarter(Date date) {
        int month = getMonth(date);
        if (month >= 1 && month <= 3) {
            return 1;
        } else if (month >= 4 && month <= 6) {
            return 2;
        } else {
            return month >= 7 && month <= 9 ? 3 : 4;
        }
    }

    public static int getQuarter() {
        return getQuarter(new Date());
    }

    public static int getDay() {
        Date now = new Date();
        return getDay(now);
    }

    public static int getDay(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return cale.get(5);
    }

    public static Date addYear(Date date, int addCount) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(1, addCount);
        return cale.getTime();
    }

    public static Date addMonth(Date date, int addCount) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(2, addCount);
        return cale.getTime();
    }

    public static Date addDay(Date date, int addCount) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(5, addCount);
        return cale.getTime();
    }

    public static String addCurDay(Date date,int addCount){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            cd.add(Calendar.DATE,addCount);
            return sdf.format(cd.getTime());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Date addHour(Date date, int addCount) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(11, addCount);
        return cale.getTime();
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(12, minutes);
        return cale.getTime();
    }


    public static int getWeekDay(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return cale.get(7) - 1;
    }


    private static int getBetweenDays(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(d1);
            c2.setTime(d2);
            if (c1.after(c2)) {
                c2.setTime(d1);
                c1.setTime(d2);
            }

            int betweenYears = c2.get(1) - c1.get(1);
            int betweenDays = c2.get(6) - c1.get(6);

            for(int i = 0; i < betweenYears; ++i) {
                c1.set(1, c1.get(1) + 1);
                betweenDays += c1.getMaximum(6);
            }

            return betweenDays;
        } else {
            return -1;
        }
    }

    public static Date strToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        return formatter.parse(date);
    }

    public static Date strToTime(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setLenient(false);
        return formatter.parse(date);
    }

    public static String dateToStr(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        }
    }

    public static String dateToStrCN(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年M月d日");
            return formatter.format(date);
        }
    }

    public static String timeToStr(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter.format(date);
        }
    }

    public static String timeToStr(long millisecond) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date(millisecond);
        return formatter.format(d);
    }

    public static Date getWeekDate(Date indate, int weeknum) {
        Calendar c = Calendar.getInstance();
        c.setTime(indate);
        c.set(7, weeknum);
        return c.getTime();
    }

    public static Date getFirstDate(Date date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-01");
        String firstdate = formatter.format(date);
        return strToDate(firstdate);
    }

    public static Date getFirstDate() throws ParseException {
        Date now = new Date();
        return getFirstDate(now);
    }

    public static Date getLastDate(Date date) throws ParseException {
        Date nextMonthfirstDate = addMonth(getFirstDate(date), 1);
        return addDay(nextMonthfirstDate, -1);
    }

    public static String getFirstYearOfWeek(int theyear, int weekIndex, int addDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(1, theyear);
        c.set(3, weekIndex);
        c.set(7, c.getFirstDayOfWeek() + addDays);
        String strdate = sdf.format(c.getTime());
        return strdate;
    }

    public static String getLastYearOfWeek(int theyear, int weekIndex, int addDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(1, theyear);
        c.set(3, weekIndex);
        c.set(7, c.getFirstDayOfWeek() + addDays);
        String strdate = sdf.format(c.getTime());
        return strdate;
    }

    public static int getCurrentWeeks() {
        Calendar cal = Calendar.getInstance();
        return cal.get(3);
    }

    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, 11, 31, 23, 59, 59);
        c.setFirstDayOfWeek(1);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(c.getTime());
        return c.get(3);
    }

    public static Date getLastDate() throws ParseException {
        Date now = new Date();
        return getLastDate(now);
    }

    public static int getMonthBetweenDate(String date1, String date2) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;

        try {
            d1 = sd.parse(date1);
        } catch (Exception var14) {
            var14.printStackTrace();
        }

        Date d2 = null;

        try {
            d2 = sd.parse(date2);
        } catch (Exception var13) {
            var13.printStackTrace();
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        int months = 0;
        int y1 = cal1.get(Calendar.YEAR);
        int y2 = cal2.get(Calendar.YEAR);
        int dm1 = cal1.get(Calendar.MONTH)+1;
        int dm2 = cal2.get(Calendar.MONTH)+1;
        int dd1 = cal1.get(Calendar.DATE);
        int dd2 = cal2.get(Calendar.DATE);
        if (d1.getTime() < d2.getTime()) {
            months = dm2 - dm1 + (y2 - y1) * 12;
            if (dd2 < dd1) {
                --months;
            }
        }

        return months;
    }

    public static String getDateString() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd");
        String s = dataFormat.format(calendar.getTime());
        return s;
    }

    public static String formatDuring(long mss) {
        if (mss <= 0L) {
            return "小于1毫秒";
        } else if (mss < 1000L) {
            return mss + "毫秒";
        } else {
            String result = "";
            long days = mss / 86400000L;
            long hours = mss % 86400000L / 3600000L;
            long minutes = mss % 3600000L / 60000L;
            long seconds = mss % 60000L / 1000L;
            if (days > 0L) {
                result = result + days + "天";
            }

            if (hours > 0L) {
                result = result + hours + "小时";
            }

            if (minutes > 0L) {
                result = result + minutes + "分";
            }

            if (seconds >= 0L) {
                result = result + seconds + "秒";
            }

            return result;
        }
    }

    public static String formatDuring(Date begin, Date end) {
        return begin != null && end != null ? formatDuring(end.getTime() - begin.getTime()) : "";
    }

    public static Date getRandomDate(Date start, Date end) {
        Random random = new Random();
        long s = start.getTime();
        long e = end.getTime();
        long rtn = s + (long)(random.nextDouble() * (double)(e - s));
        return new Date(rtn);
    }



    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month = cal.get(Calendar.MONTH)+1;
        System.out.println("month="+month);
        int day = cal.get(Calendar.DATE);
        System.out.println("day="+day);
        System.out.println(getFirstYearOfWeek(2012, 50, 1));
        System.out.println(getLastYearOfWeek(2012, 50, 5));
        new Date();
        System.out.println(getCurrentWeeks());
    }

}
