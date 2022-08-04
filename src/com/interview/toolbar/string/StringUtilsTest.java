package com.interview.toolbar.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-07-12 14:23
 */
public class StringUtilsTest {

    private static final String COLOR  = "RED";

    public static void main(String[] args) {

        String str = null;
        //适用于常量和变量的比较，有效的避免了空指针问题
        System.out.println(StringUtils.equals(COLOR,str));

        String str2 = "  abc ";
        //
        String strip = StringUtils.strip(str2);
        System.out.println(strip);

        //preserveAllTokens 参数：相邻的分隔符被标记为同一个分隔符
        String str3 = "abc  def";
        String[] split = StringUtils.split(str3);
        System.out.println(Arrays.toString(split));

    }

}