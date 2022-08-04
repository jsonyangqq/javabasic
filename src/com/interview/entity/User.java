package com.interview.entity;

import java.io.Serializable;

/**
 * @author json.yang
 * @Description 实体用户对象
 * @Date 2020-01-08
 */
public class User implements Serializable {
//    private static final long serialVersionUID = -7231737094370211919L;

    private String name;
    private int age;
    @Override
    public String toString() {
        return "{name:" + name + ",age:" + age + "}";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}