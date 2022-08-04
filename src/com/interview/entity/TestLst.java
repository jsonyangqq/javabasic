package com.interview.entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author json.yang
 * @Description 测试类
 * @Date 2020-06-21
 */
public class TestLst {

    public static void main(String[] args) {
//        Shape shape = Rectangle.getRectagle();
//        shape.lineWidth = 3d;
//        if(shape instanceof Rectangle) {
//            Rectangle rectangle = (Rectangle) shape;
//            rectangle.color = Color.BLACK;
//        }
//        System.out.println(shape);
//
//        Shape square = Square.getSquare();
//        square.lineWidth = 5d;
//        System.out.println(square);

        int[] is = new int[] {1,2,3,4,5,6};
        System.out.println(Arrays.toString(is));

        List<User> userList = new ArrayList<User>();
        userList.stream().forEach(user -> {
            if("zhangsan".equals(user.getName())) {
                user.setAge(0);
            }
        });

        String businessExt = "12.";
        String reg = "^[0-9]+(.[0-9]+)?$";
        if(businessExt.matches(reg)) {
            System.out.println("匹配成功");
        }

        System.out.println(0 == 0.00d);

        System.out.println("------");


    }

}