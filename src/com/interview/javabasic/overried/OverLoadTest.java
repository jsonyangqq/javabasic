package com.interview.javabasic.overried;

/**
 * @author jason.yang
 * @Description 测试重载
 * @Date 2020-12-20 22:30
 */
public class OverLoadTest extends A{


    public void eating(String a) {
        super.eating();
        System.out.println("重载传入的参数是："+a);
    }

    public void method1(String name, int age){
        System.out.println("");
    }

//    private void method1(String name,int age)throws Exception {
//        System.out.println("");
//    }

    // 两个方法的参数顺序不同，可以构成方法的重载
    public void method1(int age, String name){
        System.out.println("");
    }
    //---------------------------------------------
    public void method2(String name){
        System.out.println("");
    }
    // 两个方法的参数类型不同，可以构成方法的重载
    public void method2(int age){
        System.out.println("");
    }

    //---------------------------------------------
    public void method3(String name){
        System.out.println("");
    }
    // 两个方法的参数个数不同，可以构成方法的重载
    public void method3(int age, int num){
        System.out.println("");
    }

}