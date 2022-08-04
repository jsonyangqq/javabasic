package com.interview.effective.createanddrop;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author json.yang
 * @Description 创建一个有名字创建对象对象的类
 * @Date 2020-06-21
 */
public class ProcessNameCls {

    private String name;

    /*指定签名*/
    public ProcessNameCls() {

    }

    /*指定签名*/
    public ProcessNameCls(String name) {
        this.name = name;
    }

    /**
     * 这里静态工厂的方式创建对象是为了让程序员能够通过名字更加清楚的知道我们要创建一个怎样的对象
     * @return
     */
    public static ProcessNameCls getInstance() {
        return new ProcessNameCls();
    }

    /**
     * 通过不同方法名称获取同一个构造器得到的实例
     * @param name
     * @return
     */
    public static ProcessNameCls getSqureInstance(String name) {
        if("squre".equals(name)) {
            return new ProcessNameCls();
        }
        return null;
    }

}