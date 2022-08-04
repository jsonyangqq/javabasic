package com.interview.goodcode;

import lombok.var;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author json.yang
 * @Description LocalDate类没有更改器方法，与之不同，Date类有一个更改器得方法setTime，可以在这里设置毫秒数
 *              由于Date对象是可变的，这一点就破坏了封装性
 * @Date 2020-07-11
 */
public class Employee {

    public Employee() {

    }

    public Employee(Date hireDay, String name) {
        this.hireDay = hireDay;
        this.name = name;
    }

    private Date hireDay;

    private String name;

    /**
     * 访问器方法
     * @return
     */
    public Date getHireDay() {
        return (Date) hireDay.clone();
    }

    public String getName() {
        return name;
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "hireDay=" + hireDay +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee harry = new Employee(new Date(),"Tom");
        Date d = harry.getHireDay();
        double tenYearInMilliSeconds = 10 * 365.25 * 24 * 60 * 60 *1000;
        d.setTime((long) (d.getTime() - tenYearInMilliSeconds));
        System.out.println(d);
        System.out.println(harry.hireDay);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        BigDecimal bigDecimal = new BigDecimal(20);
        String format = currencyInstance.format(bigDecimal);
        System.out.println(format);

        var a = new Employee(new Date(),"Tom");
        var b = new Employee(new Date(),"Jake");
        swap(a,b);
        System.out.println(a);
        System.out.println(b);

    }




}