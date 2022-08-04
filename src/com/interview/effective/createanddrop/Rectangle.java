package com.interview.effective.createanddrop;

import java.awt.*;

/**
 * @author json.yang
 * @Description 长方形类
 * @Date 2020-06-21
 */
public class Rectangle extends Shape{

    /*背景颜色*/
    private Color color;

    private Rectangle(Color color, double lineWidth) {
        super(lineWidth);
        this.color = color;
    }

    public Rectangle(int width, int height) {
        super(width, height);
    }

    public Rectangle(int width, int height, double lineWidth, Color color) {
        super(width, height, lineWidth);
        this.color = color;
    }

    private Rectangle(double lineWidth) {
        super(lineWidth);
    }

    private Rectangle() {

    }

    /**
     * 构建无参构造器的长方形
     * @return
     */
    protected static Shape getRectagle() {
        return new Rectangle();
    }

    /**
     * 构建包含长、宽、线条粗细、背景颜色的长方形
     * @return
     */
    protected static Shape getOnlyWHRectagle(int w, int h) {
        return new Rectangle(w,h);
    }


    /**
     * 构建包含长、宽、线条粗细、背景颜色的长方形
     * @return
     */
    protected static Shape getContainerAllAttriRectagle(int width, int height, double lineWidth, Color color) {
        return new Rectangle(width,height,lineWidth,color);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color=" + color +
                ", width=" + width +
                ", height=" + height +
                ", lineWidth=" + lineWidth +
                '}';
    }

}