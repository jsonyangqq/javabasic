package com.interview.javacode;

/**
 * @author json.yang
 * @Description Sprite
 * @Date 2020-06-08
 */

/*1.请设计一个游戏项目的基础精灵类（Sprite:游戏中的元素：玩家，怪物，NPC都称之为精灵），所有的精灵都包含以下特征：
	属性：图片地址，坐标x，坐标y，宽度和高度等
	行为：初始化，绘制到界面，销毁等
现在要求创建不同的精灵子类：玩家类，敌人类，NPC类，这些类对于精灵的的行为都具有不同的实现
* */
public class Sprite {

 private String images;
 private  int x;
 private  int y;
private  int wideth;
private  int height;
    public  Sprite(String images ,int x,int y,int wideth,int height){

        this.images=images;
        this.x=x;
        this.y=y;
        this.wideth=wideth;
        this.height=height;
    }

    public void chushi()
    {
        System.out.println("初始化");
    }
    public void window()
    {
        System.out.println("窗体");
    }
    public void destory()
    {
        System.out.println("销毁");
    }
}