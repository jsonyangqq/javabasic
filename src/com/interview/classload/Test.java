package com.interview.classload;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-05-01 10:21
 */
public class Test {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String path = Test.class.getResource("").getPath();
        System.out.println(path);
        System.out.println(projectPath);
    }

}