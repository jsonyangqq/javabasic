package com.interview.arithmetic.strOpt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-08-27 17:15
 */
public class IsAnagram_Code {

    public boolean isAnagram(String s, String t) {
        /**
         全部字母进行异或运算即可解决
         */
        if(s.length() != t.length()) {
            return false;
        }
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        int result = 0;
        int result1 = 0;
        //情况1比较
        for(int i = 0;i<s.length();i++) {
            result = result ^ cs1[i] ^ cs2[i];
            result1 = result1 + cs1[i] - cs2[i];
        }
        if(result != 0 || result1 != 0) {
            return false;
        }
        //情况2比较
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(cs1[i])) {
                map.put(cs1[i], map.get(cs1[i])+1);
            }else {
                map.put(cs1[i], 1);
            }
            if(map2.containsKey(cs2[i])) {
                map2.put(cs2[i], map2.get(cs2[i])+1);
            }else {
                map2.put(cs2[i], 1);
            }
        }
        for (Character character : map.keySet()) {
            if(!map2.containsKey(character) || !map2.get(character).equals(map.get(character))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        IsAnagram_Code isAnagram_code = new IsAnagram_Code();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram_code.isAnagram(s, t));
        System.out.println('a' - 'a');
    }

}