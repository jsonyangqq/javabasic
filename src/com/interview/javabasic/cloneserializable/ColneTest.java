package com.interview.javabasic.cloneserializable;

/**
 * @author json.yang
 * @Description 克隆测试
 * @Date 2019-11-25
 */
public class ColneTest {

    class Dog {

        public Dog(){

        }
        private String name;
        private Integer age;

    }

    public static void main(String[] args) {
        //等号赋值  （基本类型）
        int number = 6;
        int number2 = number;
        number2 = 9;
        System.out.println("number:"+number);
        System.out.println("number2:"+number2);

        //等号赋值  （对象）
        Dog dog = new ColneTest().new Dog();
        dog.name = "溜溜";
        dog.age = 3;
        Dog dog2 = dog;
        dog2.name = "旺财";
        dog2.age = 5;
        System.out.println("dog name:"+dog.name+" , dog2 age:"+dog.age);
        System.out.println("dog2 name:"+dog2.name + " , dog2 age:"+dog2.age);
    }

}

