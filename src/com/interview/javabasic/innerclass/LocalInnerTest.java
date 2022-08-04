package com.interview.javabasic.innerclass;

/**
 * @author json.yang
 * @Description 局部内部类
 * @Date 2019-10-09
 */
public class LocalInnerTest {


    public static void main(String[] args) {
        new OuterClass().sayHi();
    }

}

class OuterClass{
    public void sayHi(){
        String str = "abc";
        /**
         * 1.局部内部类不能使用任何修饰符
         * 2.局部内部类如果在方法中，可以直接使用方法中得变量,不需要通过OuterClass.this.xxx的方式
         */
        class InnerClass{
            InnerClass(String name){
                System.out.println("InnerClass:"+name+""+str);
            }
        }
        System.out.println(new InnerClass("Three"));
        System.out.println("Hi,OutClass");
    }

}