package com.interview.pecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author json.yang
 * @Description
 * @Date 2020-07-09
 */
public class Listwork {


    private String str;

    //成员变量
    private List<Worker> work=new ArrayList<>();
    {
        work.add(new Worker("zhangsan",18,3000));
        work.add(new Worker("li4",25,3500));
        work.add(new Worker("wang5",36,400));
    }

    public static void main(String[] args) {
        Listwork listwork = new Listwork();
        System.out.println(listwork.work);
    }

}