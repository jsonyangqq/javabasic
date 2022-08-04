package com.interview.javacode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author json.yang
 * @Description 创建水果
 * @Date 2020-06-08
 */
public class GeneratorBn {

    public List<Firut> firutList = new ArrayList<>();
//    private  List<Map<String,Firut>> firutMapList = new ArrayList<>();

    /**
     * 定义一个初始化方法
     */
    public void initFirut() {
        firutList.add(new Apple("10001",3,"个",100,"苹果"));
        firutList.add(new Banner("10002",5,"个",50,"香蕉"));
        firutList.add(new Orange("10003",8,"个",30,"橘子"));
        System.out.println(firutList);
    }

    /**
     * @Param fnoList 水果编号集合   Map<String,Integer>  键 -》String  值 -》Integer
     * 1.卖出水果统计总价格
     * 2.更新集合库存
     * //根据水果编号和水果数量来购买水果然后更新库存来够买水果
     */
    public Double buyFirut(List<Map<String,Integer>> fnoList) {

        Double totalMoney  = 0.00;//计算购买后的总钱数
        for (Firut firut : firutList) {//
            if(fnoList != null && fnoList.size()>0 ) {
                for (Map<String, Integer> stringIntegerMap : fnoList) {
                    for(String str :  stringIntegerMap.keySet()) {
                        if(firut.getFno().equals(str)) {
                            totalMoney +=firut.getPrice() * stringIntegerMap.get(str);
                            firut.setInventory(firut.getInventory()-stringIntegerMap.get(str));
                            //获取水果索引
                            firutList.set(firutList.indexOf(firut),firut);
                        }
                    }
                }
            }
        }
        return totalMoney;
    }




}