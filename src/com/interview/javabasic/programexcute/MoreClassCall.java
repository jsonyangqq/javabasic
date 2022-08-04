package com.interview.javabasic.programexcute;

/**
 * @author json.yang
 * @Description 多类调用
 * @Date 2019-10-09
 */
public class MoreClassCall {

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        a.m(a);
        a.m(b);
        a.m(c);
        a.m(d);
    }

}

class A {
    public void m(A a) {
        System.out.println("AA");
    }
    public void m(D d) {
        System.out.println("AD");
    }
}
class B extends A {

    @Override
    public void m(A a) {
        System.out.println("BA");
    }

    public void m(B b) {
        System.out.println("BD");
    }
}
class C extends B{}
class D extends B{}