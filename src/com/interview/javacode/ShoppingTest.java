package com.interview.javacode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author json.yang
 * @Description 购买水果测试
 * @Date 2020-06-08
 */
public class ShoppingTest {

    public static void main(String[] args) {
        GeneratorBn generatorBn = new GeneratorBn();
        generatorBn.initFirut();
        List<Map<String,Integer>> mapList = new ArrayList<Map<String,Integer>>();
        Map<String,Integer> map = new HashMap<>();
        map.put("10001",3);
        Map<String,Integer> map2 = new HashMap<>();
        map.put("10002",5);
        mapList.add(map);
        mapList.add(map2);
        Double aDouble = generatorBn.buyFirut(mapList);
        System.out.println(aDouble);
        System.out.println("修改库存后的结果："+generatorBn.firutList);

        int a = 3;
        System.out.println(a << 2);
        short b = 4;
        System.out.println(b << 2);

        String regex = "(\\d{3})\\d{4}(\\d{4})";
        String phone = "13617265884";

        ;
        System.out.println(phone.replaceAll(regex, "$1****$2"));


    }

}