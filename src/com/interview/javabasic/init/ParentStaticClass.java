package com.interview.javabasic.init;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author json.yang
 * @Description 验证父类和子类初始化的时机
 * @Date 2019-09-30
 */
public class ParentStaticClass {

    private static List<String> LISTPARENT = new ArrayList<String>(){{
        System.out.println("父类静态成员变量初始化");
    }};

    static{
        System.out.println("父类静态代码块初始化");
    }

    public ParentStaticClass(){
        System.out.println("父类构造函数初始化");
    }


    public static void testStatic(){
        System.out.println("父类静态方法初始化");
    }



}