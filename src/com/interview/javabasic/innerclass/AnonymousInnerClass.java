package com.interview.javabasic.innerclass;

/**
 * @author json.yang
 * @Description 匿名内部类产生的二种情况  (重写父类的方法，或实现接口方法)
 * @Date 2019-10-09
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {

        /**
         * 匿名内部类必须实现接口中所有的抽象方法
         */
        AnonymousOuter anonymousOuter = new AnonymousOuter(){
            private String abc = "123"; //匿名内部类中可以定义非静态成员，但是不能够定义静态成员
            /**
             * 匿名内部类中实现的抽象的方法
             */
            @Override
            //匿名内部类中的方法不能够是抽象的
            public void hi() {
                System.out.println("Hi, AnonymityOuter.");
            }

            @Override
            public void hello() {

            }
        };
        anonymousOuter.hi();

        /**
         * 继承关系中的匿名内部类  误区：内部类不是一定要产生A$B这样的类才叫匿名内部类，如下也是匿名内部类的写法
         */
        ParentB parentB = new ChildSon(){
            @Override
            public void hi() {
                System.out.println("重写父类的方法");
            }
        };
        parentB.hi();
    }

}

interface AnonymousOuter{
    void hi();

    void hello();
}

class ChildSon extends ParentB{



}

 abstract class ParentB{

    public void hi(){
        System.out.println("父类 ParentB");
    }

}