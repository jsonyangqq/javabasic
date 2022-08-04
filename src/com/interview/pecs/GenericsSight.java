package com.interview.pecs;

import java.util.List;

/**
 * @author json.yang
 * @Description 不知道的泛型
 * @Date 2020-07-09
 */
public class GenericsSight {

    public static void main(String[] args) {
        //上界通配符（Upper Bounds Wildcards） 只能接收本类和其子类类型的值
//        Plate<? extends Fruit> p = new Plate<>(new Apple());
//        Plate<? extends Fruit> p1 = new Plate<>(new GreenApple());
//        Plate<? extends Fruit> p2 = new Plate<>(new Fruit());
//        System.out.println("---------- 上界通配符（Upper Bounds Wildcards） ----------");
//        System.out.println(p);
//        System.out.println(p1);
//        System.out.println(p2);
//        //Exception in thread "main" java.lang.ClassCastException: com.interview.pecs.Apple cannot be cast to com.interview.pecs.Banana
//        //苹果不能转换成香蕉，所以这里最好不要进行强制转换
//        //Banana fruit = (Banana) p.get();
//        Fruit fruit = p.get();
//        System.out.println(fruit);

        System.out.println("---------- 下界通配符（Lower Bounds Wildcards） ----------");
        //下届通配符 (Lower Bounds Wildcards)
        Plate<? super Fruit> n = new Plate<>(new Apple());
        Plate<? super Fruit> n1 = new Plate<>(new RedApple());
        n.set(new Apple());
        n.set(new Fruit());
        Food object = (Food) n.get();
        System.out.println(object);

        System.out.println(n);
        System.out.println(n1);


    }

}