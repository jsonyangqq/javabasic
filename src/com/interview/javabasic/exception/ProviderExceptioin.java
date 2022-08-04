package com.interview.javabasic.exception;

/**
 * @author json.yang
 * @Description 自定义异常
 * @Date 2019-09-29
 */
public class ProviderExceptioin {


    public static void main(String[] args) {
//        try {
//            System.out.println("try");
//        } catch (Exception e) {
//            System.out.println("catch");
//        } finally {
//            int k = 3 / 0;
//            System.out.println("finally");
//        }
//        System.out.println("main");

        System.out.println(getNumber());
    }

    public static int getNumber() {
        int number = 0;
        try {
             number = 0 / 1;
            return 2;
        }catch (ArithmeticException e){
            e.printStackTrace();
        } finally{
            number = 3;
        }
        return number;
    }

}