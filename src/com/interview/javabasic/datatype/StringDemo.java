package com.interview.javabasic.datatype;


import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author json.yang
 * @Description
 * @Date 2019-09-30
 */
public class StringDemo {


    public static void main(String[] args) {
        String str  ="nihao 你好 喬亂";
        try {
            byte[] bytes = str.getBytes("UTF-8");
            String s2 = new String(bytes);
            System.out.println(s2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //首字母大写转换成小写
        Class<StringDemo> aClass = StringDemo.class;
        String name = aClass.getName();
        System.out.println(name);
        String subString = name.substring(name.lastIndexOf(".")+1);
        String newStr = subString.substring(0,1).toLowerCase() + subString.substring(1);
        System.out.println("新的字符串为"+newStr);
        System.out.println("-------------------------------------");
        testReplace();
        splitAndMerge();

        splitAndTrim();

        //替换和删除
        //repace方法的替换主要有二种，一种时针对字符的替换，一种是针对字符串的替换

    }

    public static void testReplace(){
        String str = "hello word";
        System.out.println("替换之前的字符串:"+str);
        str = str.replace('l','d');
        System.out.println("替换所有字符:"+str);
        str = str.replace("l","d");
        System.out.println("替换所有字符串:"+str);
        str = str.replaceAll("d","l");
        System.out.println("替换全部："+str);
        str = str.replaceFirst("l","d");
        System.out.println("替换第一个："+str);
    }

    public static void splitAndMerge(){
        String str = "boo:and:foo";
        String[] split = str.split(":");//[boo, and, foo]
        System.out.println(Arrays.toString(split));
        String[] split1 = str.split(":",2);//[boo, and:foo]
        String[] split2 = str.split(":",5);//[boo, and, foo]
        String[] split3 = str.split(":",-2);//[boo, and, foo]
        String[] split4 = str.split("o");
        String[] split5 = str.split("o",2);
        System.out.println(Arrays.toString(split1));
        System.out.println(Arrays.toString(split2));
        System.out.println(Arrays.toString(split3));
        System.out.println(Arrays.toString(split4));
        System.out.println(Arrays.toString(split5));
    }

    /**
     * 从打印的结果中，可以看到去掉了空格和空值，这正是我们工作中常常期望的结果，所以推荐使用 Guava 的 API 对字符串进行分割。
     */
    public static void splitAndTrim(){
        String a =",a, ,  b  c ,";
        // Splitter 是 Guava 提供的 API
        List<String> list = Splitter.on(',')
                .trimResults()//去掉空格
                .omitEmptyStrings()//去掉空值
                .splitToList(a);
        System.out.println("Guava去掉空格后分割的方法："+ JSON.toJSONString(list));

        //String来实现字符串的合并
        String b = "hello ";
        String c = "word ";
        String d = "welcome";
        String joinStr = String.join(",",b).join(",",c);
        //通过字符串的join方法，后面一个总是会把前面一个进行覆盖
        System.out.println("多个join之后得到的字符串"+joinStr);
        List<String> stringList = new ArrayList<>();
        stringList.add(null);
        stringList.add("hello");
        stringList.add("word");
        //如果用string的join无法自动过滤掉空值
        String joinList = String.join(",", stringList);
        System.out.println(joinList);

        System.out.println("------------------------------------------");
        //使用Guava来实现多重join
        Joiner joiner = Joiner.on(",").skipNulls();
        String reuslt = joiner.join("hello", null, "china");
        System.out.println(reuslt);

        List<String> lists = Lists.newArrayList(new String[]{"hello","china",null});
        System.out.println("自动删除list中的空值"+joiner.join(lists));




    }

}