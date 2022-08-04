package com.interview.effective.createanddrop;

import java.awt.*;

/**
 * @author json.yang
 * @Description 正方形类
 * @Date 2020-06-21
 */
public class Square extends Shape{

    private Square() {

    }

    public Square(int width, int height) {
        super(width, height);
    }

    public Square(double lineWidth) {
        super(lineWidth);
    }

    public Square(int width, int height, double lineWidth) {
        super(width, height, lineWidth);
    }

    protected static Shape getSquare() {
        return new Square();
    }

    protected static Shape getOnlyWHSquare(int w, int h) {
        if(w != h) {
            throw new NoGeneratorCurShapeException("构建的正方形失败!");
        }
        return new Square(w, h);
    }

    protected static Shape getContainerAllAttriSquare(int width, int height, double lineWidth) {
        if(width != height) {
            throw new NoGeneratorCurShapeException("构建的正方形失败!");
        }
        return new Square(width, height, lineWidth);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", height=" + height +
                ", lineWidth=" + lineWidth +
                '}';
    }
}