package com.interview.test;

import com.interview.wide.io.SerializableWay;
import javafx.scene.image.ImageView;
import lombok.var;

import java.awt.*;
import java.math.BigDecimal;

/**
 * @author json.yang
 * @Description 多种方式序列化测试
 * @Date 2020-01-08
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception {
//        SerializableWay serializableWay = new SerializableWay();
//        //方式1
//        serializableWay.protogeSerializable();
        //方式2：
//        serializableWay.fastJsonSerializable();
//        //方式3：
//        serializableWay.hessionSerializable();

        BigDecimal bigDecimal = BigDecimal.valueOf(10);
        bigDecimal.add(new BigDecimal(3));
        System.out.println(bigDecimal);
        String str = new String("123");
        str.substring(0,1);
        System.out.println(str);
        EventQueue.invokeLater(() -> {
            var frame = new ImageView();
        });
        String joinStr = String.join(" / ", "S", "M", "L", "XL");
        String joinStrTwo = String.join(",","1","2","3","4");
        System.out.println(joinStr);
        System.out.println(joinStrTwo);
        int index = joinStr.offsetByCodePoints(0,joinStr.length());
        char ch = joinStr.charAt(1);
        System.out.println(ch);
        System.out.println(index);
        int[] codePoints = joinStr.codePoints().toArray();
        System.out.println(codePoints);
        String strA = new String(codePoints,0,codePoints.length);
        System.out.println(strA);
    }

}