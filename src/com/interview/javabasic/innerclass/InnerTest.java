package com.interview.javabasic.innerclass;

/**
 * @author json.yang
 * @Description 内部类使用测试
 * @Date 2019-10-09
 */
public class InnerTest {

    public static void main(String[] args) {
        Outer outer = new Outer();
        //创建成员内部类
        Outer.Inner inner = new Outer.Inner();//内部类中是静态内部类时创建方式
        inner.sayHi();
        Outer.InnerTwo innerTwo = new Outer().new InnerTwo();
        innerTwo.sayHi();

        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
    }

}


class Outer{

    private String name = "OuterClass";
    private static int age = 20;

    /**
     * 外部类访问内部类时时没有任何限制的,只要是内部类可以定义的，外部类都可以访问得到
     */
    public Outer(){
        System.out.println("------------------------------- 外部类访问静态内部类时 -------------------------------");
        System.out.println(Inner.str);
        System.out.println(new Inner().sb);
        new Inner().sayHi();
        new Inner().sayTo();
        System.out.println("Outer Class.");
        System.out.println("------------------------------- 外部类访问非静态内部类时 -------------------------------");
        System.out.println(new InnerTwo().sb);
        new InnerTwo().sayHi();
    }
    static class Inner{
        /**
         * 静态内部类可以定义非静态属性和非静态方法
         */
        private static String str = "Hello";
        private String sb = "word";
        /**
         * 静态内部类只能够访问外部类的静态属性和静态方法
         */
        public void sayHi(){
            System.out.println(Outer.age);
            //Non-static field 'name' cannot be referenced from a static context 不能从静态上下文引用非静态的内容
//            System.out.println(Outer.name);
            System.out.println("Hi,static-Inner.");
        }

        public static void sayTo(){
            System.out.println("Hi,static-Inner-Method.");
        }
    }

    class InnerTwo{
        //Inner classes cannot have static declarations  非静态内部类不能有静态的声明
//        private static String str = "Hello";
        private String sb = "word";
        public void sayHi(){
            System.out.println(Outer.this.age);
            System.out.println(Outer.this.name);
            System.out.println("Hi,No-static-Inner.");
        }
    }

}

