package com.interview.javabasic.ss;

/**
 * @author jason.yang
 * @Description 显示调用父类构造器
 * @Date 2020-12-21 13:53
 */
public class ShowCallFather {
}

class A {

    public A() {

    }

    public A(String name) {

    }

}

class B extends A{

    public B() {
        A a1 = new A("张三");
    }


}
