package com.interview.javabasic.cloneserializable;

import java.io.Serializable;

/**
 * @author json.yang
 * @Description 浅拷贝解决引用类型克隆问题
 * @Date 2019-11-25
 */
public class ColneTestTwo {

    class Dog implements Cloneable{

        public Dog(){

        }
        private String name;
        private Integer age;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //等号赋值  （对象）
        Dog dog = new ColneTestTwo().new Dog();
        dog.name = "溜溜";
        dog.age = 3;
        Dog dog2 = (Dog) dog.clone();
        dog2.name = "旺财";
        dog2.age = 5;
        System.out.println(dog.name + "，" + dog.age + "岁");
        System.out.println(dog2.name + "，" + dog2.age + "岁");
    }

}