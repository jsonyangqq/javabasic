package com.interview.pecs;

/**
 * @author json.yang
 * @Description 盘子类
 * @Date 2020-07-09
 */
public class Plate<T> {

    private T item;

    public Plate(T t) {
        this.item = t;
    }

    public void set(T t) {
        this.item = t;
    }

    public T get() {
        return this.item;
    }

}