package com.interview.arithmetic.strOpt;

import com.interview.javabasic.mutithread.Str;

import java.util.*;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-08-27 15:28
 */
public class FirstUniqChar_Code {

    public int firstUniqChar(String s) {
        if(s == null || "".equals(s)) {
            return -1;
        }
        if(s.length() == 1) {
            return 0;
        }
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        List<Character> list = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < cs.length; i++) {
            list.add(cs[i]);
            if(map.containsKey(cs[i])) {
                map.put(cs[i],map.get(cs[i])+1);
            }else {
                map.put(cs[i], 1);
            }
        }

        for (Character character : map.keySet()) {
            if(map.get(character) == 1) {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).equals(character)) {
                        index = i;
                        break;
                    }
                }
                break;
            }
        }
        return index;
    }

    public int firstUniqChar_02(String s) {
        if(s == null || "".equals(s)) {
            return -1;
        }
        if(s.length() == 1) {
            return 0;
        }
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<cs.length; i++) {
            //默认表示不存在重复的
            boolean flag = false;
            if(map.containsKey(cs[i])) {
                continue;
            }
            for(int j=i+1; j< cs.length; j++) {
                if(map.containsKey(cs[j])) {
                    continue;
                }
                if(cs[i] == cs[j]) {
                    //将重复的值都给记录下来
                    map.put(cs[i],2);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FirstUniqChar_Code firstUniqChar_code = new FirstUniqChar_Code();
        String str = "loveleetcode";
        System.out.println(firstUniqChar_code.firstUniqChar_02(str));
        char a = 'a';
        char b = 'b';
        char c = 'b';
        char d = 'a';
        System.out.println(a ^ b ^ c ^ d);
    }

}