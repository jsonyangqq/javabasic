package com.interview.javabasic.collection;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-06-25 17:08
 */
public class AirthException {

    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        byte[] bytes = a.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        char[] chars = a.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        int h = a.hashCode() ^ b.hashCode();
        int a1 = h ^ a.hashCode();
        int b1 = h ^ b.hashCode();
        System.out.println();
        System.out.println();


    }

}