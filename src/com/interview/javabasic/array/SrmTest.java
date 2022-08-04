package com.interview.javabasic.array;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author json.yang
 * @Description
 * @Date 2019-12-06
 */
public class SrmTest {

    private static Map<String,Object> mapping = new HashMap<String,Object>(){{
        put("abc",123);
        put("abc",456);
    }};

    public static void main(String[] args) {
        mapping.put("id",123);
        //针对HashMap操作时得出的结论
        //结论1 -> 当key值重复的时候，后面的value值会把前面的值进行覆盖掉
        for (String s : mapping.keySet()) {
            System.out.println("key值为："+s + "," + "value值为："+mapping.get(s));
            mapping.put("name","Jason");
            mapping.remove("abc");
        }
        System.out.println();
        System.out.println("------------------------------------------------");

        for (String s : mapping.keySet()) {
            System.out.println("key值为："+s + "," + "value值为："+mapping.get(s));
        }



    }


}