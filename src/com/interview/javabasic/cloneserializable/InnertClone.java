package com.interview.javabasic.cloneserializable;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Objects;
import java.util.RandomAccess;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-02-25 10:45
 */
public class InnertClone<T> {

    private final T[] menus;

    public InnertClone(T[] array) {
        menus = array;
    }

    public Object[] siley() {
        return menus.clone();
    }



    public static class ArrayList<E> extends AbstractList<E>implements RandomAccess, java.io.Serializable {

        private static final long serialVersionUID = -2764017481108945198L;
        private final E[] a;

        ArrayList(E[] array) {
            a = Objects.requireNonNull(array);
        }

        @Override
        public E get(int index) {
            return a[index];
        }

        @Override
        public int size() {
            return a.length;
        }

        @Override
        public Object[] toArray() {
            return a.clone();
        }

    }

}