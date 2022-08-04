package com.interview.javabasic.cloneserializable;

/**
 * @author json.yang
 * @Description 使用浅克隆存在的问题
 * @Date 2019-11-26
 */
public class CloneTestThree {

    public static void main(String[] args) throws CloneNotSupportedException {
        DogChild dogChild = new DogChild();
        dogChild.name = "二狗";
        Dog dog4 = new Dog();
        dog4.name = "大黄";
        dog4.dogChild = dogChild;
        Dog dog5 = (Dog) dog4.clone();
        dog5.name = "旺财";
        dog5.dogChild.name = "狗二";
        System.out.println("dog name 4："+dog4.name);
        System.out.println("dog name 5："+dog5.name);
        System.out.println("dog child name 4："+dog4.dogChild.name);
        System.out.println("dog child name 5："+dog5.dogChild.name);
    }

}


/**
 * 创建的dog对象  里面包含dog孩子对象
 */
class Dog implements Cloneable {
    public String name;
    public DogChild dogChild;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/**
 * dog孩子对象
 */
class DogChild {
    public String name;
}

