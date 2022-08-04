package com.interview.javabasic.scanner;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author json.yang
 * @Description
 * @Date 2020-06-26
 */
public class InputTest {

    public static void main(String[] args) throws IOException {
        System.out.printf("%tF",new Date());
//        Scanner in = new Scanner(Path.of("myfile.txt"),StandardCharsets.UTF_8);  java11有的方法
//        System.out.println(in);
        String[] authors = {"James Gosling","Bill Joy",};
        System.out.println(Arrays.toString(authors));

        String str = "if 职务 = 一般员工";
        String strVal = "职务 = 部门经理";
        String[] split = str.split("=");
        for (String s : split) {
            if(!StringUtils.isBlank(s)) {
                System.out.println(recursiveSplit(s));
            }
        }
        System.out.println(Arrays.toString(split));

        Integer a1 = 3;
        Integer b1 = 5;
        String s1 = "*";

        



    }


    private static String recursiveSplit(String str) {
        String[] newStrArr = new String[0];
        if(str.contains("if")) {
            newStrArr = str.split("if");
        }else if(str.contains("else")) {
            newStrArr = str.split("else");
        }else if(str.contains("else if")) {
            newStrArr = str.split("else if");
        }
        if(newStrArr != null && newStrArr.length > 0) {
            return newStrArr[1].trim();
        }
        return str.trim();
    }


}