package com.interview.javabasic.cloneserializable;

/**
 * @author json.yang
 * @Description 深度克隆实现方式二：所有引用类型都实现克隆
 * @Date 2019-11-29
 */

public class CloneTestFree {

    public static void main(String[] args) throws CloneNotSupportedException {

        ParrotChild parrotChild = new ParrotChild();
        parrotChild.name = "小鹦鹉";
        Parrot parrot = new Parrot();
        parrot.name = "大鹦鹉";
        parrot.parrotChild = parrotChild;

        //开始完成克隆
        Parrot parrotCopy = (Parrot) parrot.clone();
        parrotCopy.name = "老鹦鹉";
        parrotCopy.parrotChild.name = "少鹦鹉";

        System.out.println("parrot name:" + parrot.name);
        System.out.println("parrot child name:" + parrot.parrotChild.name);
        System.out.println("parrot name 2:" + parrotCopy.name);
        System.out.println("parrot child name 2:" + parrotCopy.parrotChild.name);
    }


}

class Parrot implements Cloneable {
    public String name;
    public ParrotChild parrotChild;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Parrot parrot  = (Parrot) super.clone();
        parrot.parrotChild = (ParrotChild) parrotChild.clone();
        return parrot;
    }
}

class ParrotChild implements Cloneable{
    public String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}