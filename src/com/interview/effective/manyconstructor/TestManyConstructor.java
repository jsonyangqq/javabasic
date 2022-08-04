package com.interview.effective.manyconstructor;

/**
 * @author json.yang
 * @Description 测试多构造器类
 * @Date 2020-06-23
 */
public class TestManyConstructor {

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts(200, 100);
        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        sb.append("123");
        System.out.println(sb.toString());

        String str = "12345";
        str.substring(1,3);
        System.out.println(str);
        NutritionFactsBd factsBd = new NutritionFactsBd.Builder(240, 8).calories(10).build();
        System.out.println(factsBd);


    }

}