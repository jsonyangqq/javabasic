package com.interview.javabasic.programexcute;

/**
 * @author json.yang
 * @Description 变量和方法的重写问题  (重写发生在父类和子类)
 * 在java语言中，变量不能被重写
 * @Date 2019-10-09
 */
public class VariableAndMethod {

    public static void main(String[] args) {
        A1 myClass = new B1();
        System.out.println(myClass.x);
        System.out.println(myClass.y);
        myClass.m();//m方法会被重写
    }

}

class A1{
    public int x = 0;
    public static int y = 0;
    public void m(){
        System.out.println("A");
    }
}

class B1 extends A1{
    public int x = 1;
    public static int y = 2;
    public void m(){
        System.out.println("B");
    }
}