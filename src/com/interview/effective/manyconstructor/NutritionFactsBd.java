package com.interview.effective.manyconstructor;

/**
 * @author json.yang
 * @Description 改造的营养成分标签类  （这个类创建了之后，就变成了不可变的类了）
 * @Date 2020-06-23
 */
public class NutritionFactsBd {

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

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        //Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            calories = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFactsBd build() {
            return new NutritionFactsBd(this);
        }

    }


    private NutritionFactsBd(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFactsBd{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}