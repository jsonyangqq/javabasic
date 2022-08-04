package com.interview.javabasic.classload;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author json.yang
 * @Description 程序代码执行的顺序
 * @Date 2019/8/11
 */
public class ObjectLoadSequence {

    private static ObjectLoadSequence objOne = new ObjectLoadSequence();
    private static ObjectLoadSequence objTwo = new ObjectLoadSequence();

    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        ObjectLoadSequence objs = new ObjectLoadSequence();
        
        Map<String,Object> map = new HashMap<>();
        map.put(null,null);
        for (String s : map.keySet()) {
            System.out.println(s);
        }

        int[] a = new int[4];
        int j = 0;
        for (int i = 0; 4 <a.length ; i++) {
            System.out.println(a);
        }
        System.out.println("for循环结束了"+j);
        System.out.println(Arrays.toString(a));

        while (4 == j ){
            j++;
        }

    }


}