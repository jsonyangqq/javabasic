package com.interview.javabasic.sort;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author json.yang
 * @Description 排序
 * @Date 2019-09-30
 */
public class ArraysDemo {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    public static void main(String[] args) {
        List<SortDTO> list = ImmutableList.of(
                new SortDTO("300"),
                new SortDTO("50"),
                new SortDTO("200"),
                new SortDTO("220")
        );
        // 我们先把数组的大小初始化成 list 的大小，保证能够正确执行 toArray
        SortDTO[] array = new SortDTO[list.size()];
        list.toArray(array);
        System.out.println("排序之前:"+ JSON.toJSONString(array));
        Arrays.sort(array, Comparator.comparing(SortDTO::getSortTarget));
        System.out.println("排序之后："+JSON.toJSONString(array));

        Class<? extends Object[]> aClass = Object[].class;
        System.out.println(aClass);

        List<String> lists = new ArrayList<>();
        System.out.println(lists);
    }

}


class SortDTO {
    public String getSortTarget() {
        return sortTarget;
    }

    public void setSortTarget(String sortTarget) {
        this.sortTarget = sortTarget;
    }

    private String sortTarget;

    public SortDTO(String sortTarget) {
        this.sortTarget = sortTarget;
    }



}
