package com.interview.javabasic.mutithread.threadpool;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author jason.yang
 * @Description 线程池的基本使用
 * @Date 2021-05-16 11:12
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
//        System.out.println(sss());

        Map<String, Object> map = new HashMap<>();
        ArrayList<String> businessKeyList = Lists.newArrayList();
        businessKeyList.add("123456");
        businessKeyList.add("654321");
        map.put("business_type", "fjkldsjlfk");
        map.put("businessKeyList", businessKeyList);

        System.out.println(map);

        List<String> businessKeyList1 = (List<String>) map.get("businessKeyList");
        System.out.println(businessKeyList1);


        ArrayList<User> objects = Lists.newArrayList();
        User user = new User("zhangsan", 10);
        User user1 = new User("lisi", 12);
        User user2 = new User("zhaowu", 15);
        User user4 = new User("zhangsan", 10);
        objects.add(user);
        objects.add(user1);
        objects.add(user2);
        objects.add(user4);
//        List<String> stringList = new ArrayList<>();
//        stringList.add("lisi");
//        List<User> collect = objects.stream().filter(user3 -> stringList.contains(user3.getUsername())).collect(Collectors.toList());
//        System.out.println(collect);
        String number = "2379847";
        number.matches("[0-9]{3}-[0-9]{4}");
        Map<String, List<User>> collect = objects.stream().collect(Collectors.groupingBy(us -> String.join("-",us.getUsername() , us.getAge().toString()), Collectors.toList()));
        System.out.println(collect);
        System.out.println(collect.size());


    }

//    private static String sss() {
//        ExecutorService thread = Executors.newFixedThreadPool(5);
//        ExecutorService thread1 = Executors.newSingleThreadExecutor();
//        ExecutorService thread2 = Executors.newCachedThreadPool();
//
//        try{
//            //模拟10个用户办理业务
//            for (int i = 1; i <= 1000; i++) {
//                int finalI = i;
//                thread.execute(() -> {
//                    System.out.println(Thread.currentThread().getName()+"\t"+"办理业务"+ finalI);
//                });
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            thread.shutdown();
//        }
//        return "结束了";
//    }
//
//}

}
@Data
class User {
    public String username;

    public Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}