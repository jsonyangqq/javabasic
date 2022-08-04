package com.interview.classload;

/**
 * @author jason.yang
 * @Description  关于继承中的扩展点
 * @Date 2020-12-20 8:25
 */
public class ExtendsDemo {



}

class Father{

    private String name;

    private int age;

    protected double height;

    String idno;

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    String getIdno() {
        return idno;
    }

    void setIdno(String idno) {
        this.idno = idno;
    }
}

class Son extends Father {

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    @Override
    String getIdno() {
        return super.getIdno();
    }
}