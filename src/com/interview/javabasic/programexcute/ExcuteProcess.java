package com.interview.javabasic.programexcute;

/**
 * @author json.yang
 * @Description 程序执行流程处理
 * 程序的加载顺序如下：
 * 1.执行父类的静态成员，执行父类静态代码块
 * 2.执行子类的静态成员,执行子类静态代码块
 * 3.执行父类实例成员和实例初始化
 * 4.执行父类构造方法
 * 5.执行子类实例成员和子类初始化
 * 6.执行子类构造方法
 * @Date 2019-10-09
 */
public class ExcuteProcess {

    public static void main(String[] args) {
        Son son = new Son();
    }

}

class Parent{
    {
        System.out.println("1");
    }
    static {
        System.out.println("2");
    }
    public Parent(){
        System.out.println("3");
    }
}

class Son extends Parent{
    {
        System.out.println("4");
    }
    static{
        System.out.println("5");
    }
    public Son(){
        System.out.println("6");
    }
}
