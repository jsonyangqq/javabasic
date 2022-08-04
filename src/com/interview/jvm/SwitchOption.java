package com.interview.jvm;

/**
 * @author json.yang
 * @Description
 * @Date 2020-07-10
 */
public class SwitchOption {

    public static void main(String[] args) {
            String param = null;
            switch (param) {
                case "a":
                    System.out.println("a");
                    break;
                case "b":
                    System.out.println("b");
                    break;
                case "c":
                    System.out.println("c");
                    break;
                default:
                    System.out.println("default");
            }
    }

}