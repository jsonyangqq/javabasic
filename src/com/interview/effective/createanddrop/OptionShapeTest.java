package com.interview.effective.createanddrop;

import com.mysql.jdbc.Driver;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.EnumSet;

/**
 * @author json.yang
 * @Description 选择形状测试
 * @Date 2020-06-21
 */
public class OptionShapeTest {

    public static void main(String[] args) {
        /*构建一个所有属性都为初始值的长方形对象*/
        Shape shape = Rectangle.getRectagle();
        Rectangle rectangle = (Rectangle) shape;
//        rectangle.color = Color.RED;
        System.out.println(shape);
        System.out.println(rectangle);

        /*构建一个仅仅包含宽高的长方形对象*/
        Shape whRectagle = Rectangle.getOnlyWHRectagle(5, 8);
        System.out.println(whRectagle);


        /*构建一个所有属性都为初始值的正方形对象*/
        Shape square = Square.getSquare();
        System.out.println(square);

        Shape whSquare = Square.getOnlyWHSquare(6, 6);
        System.out.println(whSquare);

        //如果枚举类型中元素小于65个，则工厂会返回RegularEnumSet类，否则会返回JumboEnumSet类
        EnumSet<StatusEnum> statEnum = EnumSet.of(StatusEnum.STAT_ENUM);
        for (StatusEnum statusEnum : statEnum) {
            System.out.println(statusEnum.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("", "", "");
            Statement statement = connection.createStatement();
            statement.execute("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}