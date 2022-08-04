package com.interview.javabasic.init;

/**
 * @author jason.yang
 * @Description 调用静态方法测试类初始化加载顺序
 * @Date 2020-12-20 22:13
 */
public class CallStaticMethod {

    public static void main(String[] args) {
        StaticClass.testStatic();
    }

}