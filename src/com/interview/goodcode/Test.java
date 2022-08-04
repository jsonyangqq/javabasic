package com.interview.goodcode;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author json.yang
 * @Description
 * @Date 2020-08-07
 */
public class Test {

    public static void main(String[] args) {
        //测试union
        String[] arr1 = {"个人编码", "姓名", "班组","性别","岗位","批次",
                "身份证号码","生日月份","入职时间","签合同时间","备注","是否全勤",
                "月工作量","单价（元）","月工作量（班长）","KPI得分","扣款项（元）","应发岗位工资（元）","支撑补贴","话务量"};
        String[] arr2 = {"abc", "cc", "df", "d", "abc"};
        String[] arr3 = {"abc", "cc", "df", "d", "abc"};
        String[] arr4 = {"abc", "cc", "df", "d", "abc"};
        String[] arr5 = {"abc", "cc", "df", "d", "abc"};
        String[] result_union = union(arr1, arr2);
        System.out.println("求并集的结果如下：");
        for (String str : result_union) {
            System.out.println(str);
        }

        //测试insect
        String[] result_insect = intersect(arr1, arr2);
        System.out.println("求交集的结果如下：");
        for (String str : result_insect) {
            System.out.println(str);
        }
        //测试 substract
        String[] result_minus = substract(arr1, arr2);
        System.out.println("求差集的结果如下：");
        for (String str : result_minus) {
            System.out.println(str);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        String childNodeOrgId = "00000500";
        String currnetSuperOrgId = "000005";
        String replace = childNodeOrgId.replace(currnetSuperOrgId, "");
        System.out.println(replace);



    }

    //并集（set唯一性）
    public static String[] union (String[] arr1, String[] arr2){
        Set<String> hs = new HashSet<String>();
        for(String str:arr1){
            hs.add(str);
        }
        for(String str:arr2){
            hs.add(str);
        }
        String[] result={};
        return hs.toArray(result);
    }

    //交集(注意结果集中若使用LinkedList添加，则需要判断是否包含该元素，否则其中会包含重复的元素)
    public static String[] intersect(String[] arr1, String[] arr2){
        List<String> l = new LinkedList<String>();
        Set<String> common = new HashSet<String>();
        for(String str:arr1){
            if(!l.contains(str)){
                l.add(str);
            }
        }
        for(String str:arr2){
            if(l.contains(str)){
                common.add(str);
            }
        }
        String[] result={};
        return common.toArray(result);
    }
    //求两个数组的差集
    public static String[] substract(String[] arr1, String[] arr2) {
        LinkedList<String> list = new LinkedList<String>();
        for (String str : arr1) {
            if(!list.contains(str)) {
                list.add(str);
            }
        }
        for (String str : arr2) {
            if (list.contains(str)) {
                list.remove(str);
            }
        }
        String[] result = {};
        return list.toArray(result);
    }

    public void nonStaticMethod() {
        System.out.println("打印一句话：");
    }

    public void sss() {
        Test.this.nonStaticMethod();
    }

    public void mmm() {
        Test.this.nonStaticMethod();
    }

}