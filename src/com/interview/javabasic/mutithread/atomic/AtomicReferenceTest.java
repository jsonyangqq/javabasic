package com.interview.javabasic.mutithread.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author jason.yang
 * @Description 原子引用
 * @Date 2021-04-15 11:24
 */

class User {
    private String name;

    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

public class AtomicReferenceTest {

    private static AtomicReference<User> userAtomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("zhangsan","20");
        User user2 = new User("lisi", "24");

        AtomicReference<User> reference = new AtomicReference<>();
        reference.set(user);

        System.out.println(reference.compareAndSet(user, user2)+"\t"+reference.get().toString());
        System.out.println(reference.compareAndSet(user, user2)+"\t"+reference.get().toString());



    }

}