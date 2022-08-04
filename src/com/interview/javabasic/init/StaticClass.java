package com.interview.javabasic.init;

import java.util.ArrayList;
import java.util.List;

/**
 * @author json.yang
 * @Description 验证父类和子类初始化的时机
 *
 * 执行顺序为   父类静态变量初始化-》父类静态代码块初始化—》子类静态变量初始化-》子类静态代码块初始化-》父类构造函数初始哈-》子类构造函数初始化
 *
 * @Date 2019-09-30
 */
public class StaticClass extends ParentStaticClass{

    public static List<String> LIST = new ArrayList<String>(){{
        System.out.println("子类静态变量初始化");
    }};

    static {
        System.out.println("子类静态代码块初始化");
    }

    public StaticClass(){
        System.out.println("子类构造器初始化");
    }

    public static void testStatic(){
        System.out.println("子类静态方法初始化");
    }

    public static void main(String[] args) {
        System.out.println("main方法执行");
//        new ParentStaticClass();
    }



}