package com.interview.effective.createanddrop;


/**
 * 创建一个形状类
 */
public class Shape {

    protected int width;

    protected int height;

    /*线条粗细*/
    protected double lineWidth;

    public Shape() {

    }

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Shape(double lineWidth) {
        this.width = width;
        this.lineWidth = lineWidth;
    }

    public Shape(int width, int height, double lineWidth) {
        this.width = width;
        this.height = height;
        this.lineWidth = lineWidth;
    }

}
