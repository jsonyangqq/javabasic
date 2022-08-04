package com.interview.javabasic.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author json.yang
 * @Description 简单数组的常用操作
 * @Date 2019-10-08
 */
public class SimpleArray {

    static Integer[] arr = {2, 3, 6, 7, 9};


    public static void main(String[] args) {
        System.out.println("-------------------  for-i  -------------------");
        foriCycle();
        System.out.println("-------------------  for-each  -------------------");
        foreachCycle();
        System.out.println("-------------------  for-lambda  -------------------");
        lambdaCycle();
        System.out.println("-------------------  实现数组的拷贝  -------------------");
        arrayCopyOf();
        System.out.println("-- -----------------  实现数组的填充  -------------------");
        arrayFill();
        System.out.println("-- -----------------  实现数组的合并  -------------------");
        arrayMerge();
        System.out.println("-- -----------------  实现数组的排序  -------------------");
        arraySort();
        System.out.println("-- -----------------  实现数组的逆序  -------------------");
        arrayReverse();
        System.out.println("-- -----------------  实现数组的冒泡排序  -------------------");
        BubbleSort();
        System.out.println("-- -----------------  实现数组的选择排序  -------------------");
        selectSort();
        System.out.println("-- -----------------  二分法查找某值  -------------------");
        binarySearch();
        System.out.println("-- -----------------  字符串转换成数组  -------------------");
        strCoverArray();
        System.out.println("-- -----------------  数组转换成字符串  -------------------");
        arrayCoverStr();
        System.out.println("-- -----------------  数组转换成集合  -------------------");
        arrayCoverList();
        System.out.println("-- -----------------  集合转换成数组  -------------------");
        listCoverArray();
        System.out.println("-- -----------------  数组间的比较  -------------------");
        compareToArray();
    }

    /**
     * for-i方式进行数组的遍历
     */
    public static void foriCycle(){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(i);
        }
    }

    /**
     * foreach方式进行数组的遍历
     */
    public static void foreachCycle(){
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }

    /**
     * lambda表达式进行数组的遍历
     */
    public static void lambdaCycle(){
        Arrays.asList(arr).forEach(x -> System.out.println(x));
    }

    /**
     * 实现数组的拷贝
     */
    public static void arrayCopyOf(){
        int[] arr = {3,4,9};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 实现数组的填充
     * 使用fill方法之后，无论数组内部是否有值，都会被填充为统一的值
     */
    public static void arrayFill(){
        int[] arr2 = new int[10];
        Arrays.fill(arr2,6);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 数组合并
     */
    public static void arrayMerge(){
        int[] arr = {2,8,13,11,6,7};
        int[] arr2 = {66,88};
        int[] arr3 = org.apache.commons.lang3.ArrayUtils.addAll(arr,arr2);
        System.out.println(Arrays.toString(arr3));
    }

    /**
     * 数组排序
     */
    public static void arraySort(){
        int[] arr = {2, 8, 13, 11, 6, 7};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 数组逆序  逆序和倒序概念是不一致的，逆序表示没有进行排序直接把数组转一个180排列，所以要从大到小排列时需要先排序后在逆序操作即可
     */
    public static void arrayReverse(){
        int[] arr = {2, 8, 13, 11, 6, 7};
        System.out.println("逆序之前排列:"+Arrays.toString(arr));
        org.apache.commons.lang3.ArrayUtils.reverse(arr);
        System.out.println("逆序之后排列"+Arrays.toString(arr));
    }

    /**
     * 冒泡排序 算法的实现是每次循环遍历找出最大只放在最后面,然后最后一个值不参与比较了，一共需要遍历arr.length-1次
     */
    public static void BubbleSort(){
        int[] arr = {2, 8, 13, 11, 6, 7};
        System.out.println("排序前：" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                int temp;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 实现选择排序  和冒泡排序其实原理一样，只是它是把最小的值都选择出来放在最前面
     */
    public static void selectSort(){
        int[] arr = {2, 8, 13, 11, 6, 7};
        System.out.println("排序前：" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int lowerIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                //找出最小的数的索引
                if(arr[j] < arr[lowerIndex]){
                    lowerIndex = j;
                }
            }
            //交换位置
            int temp = arr[i];
            arr[i] = arr[lowerIndex];
            arr[lowerIndex]=temp;
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 二分查找法
     * 使用 Arrays.binarySearch 之前一定要先调用 Arrays.sort() 对数组进行排序，否则返回的结果有误。
     */
    public static void binarySearch(){
        int[] arr = {1,3,4,5};
        Arrays.sort(arr);
        //Arrays.binarySearch() 二分查找某值
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);

    }

    /**
     * 字符粗转换成数组
     */
    public static void strCoverArray(){
        String str = "laowang,stone,wanglei";
        String[] arr = str.split(",");
        System.out.println(arr[0]);
    }

    /**
     * 数组转换成字符串
     */
    public static void arrayCoverStr(){
        String[] arr = {"laowang","stone","wanglei"};
        String str = Arrays.toString(arr);
        System.out.println(str);
    }

    /**
     * 数组转换成集合
     */
    public static void arrayCoverList(){
        String[] arr = {"laowang","stone","wanglei"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
    }

    /**
     * 集合转换成数组
     */
    public static void listCoverArray(){
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        //集合转换成数组
        String[] str = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(str));
    }

    /**
     * 数组间的比较
     */
    public static void compareToArray(){
        String[] strArr = {"dog", "cat", "pig", "bird"};
        String[] strArr2 = {"dog", "cat", "pig", "bird"};
        System.out.println(Arrays.equals(strArr, strArr2));
        System.out.println(strArr.equals(strArr2));
        System.out.println(strArr == strArr2);
    }



}