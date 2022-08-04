package com.interview.effective.manyconstructor;

/**
 * @author json.yang
 * @Description 营养成分标签类
 * @Date 2020-06-22
 */
public class NutritionFacts {

    /**
     * 总脂肪量
     */
    private final int servingSize;

    /**
     * 饱和脂肪量
     */
    private final int servings;

    /**
     * 消耗卡路里量
     */
    private final int calories;

    /**
     * 胆固醇量
     */
    private final int fat;

    /**
     * 纳的数量
     */
    private final int sodium;

    /**
     * 碳水化合物数量
     */
    private final int carbohydrate;

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize,servings,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize,servings,calories,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize,servings,calories,fat,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize,servings,calories,fat,sodium,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}