package com.interview.javabasic.cloneserializable;

import com.interview.javabasic.cloneserializable.model.Bird;
import com.interview.javabasic.cloneserializable.model.BirdChild;

import java.io.*;

/**
 * @author json.yang
 * @Description 测试序列化方式实现深克隆
 * @Date 2019-11-26
 */
public class CloneTestFour {

    public static void main(String[] args) {
        BirdChild birdChild = new BirdChild();
        birdChild.name = "小小鸟";
        Bird bird = new Bird();
        bird.name = "小鸟";
        bird.birdChild = birdChild;
        //使用序列化方式克隆对象
        Bird bird2 = CloneUtils.clone(bird);
        bird2.name = "黄雀";
        bird2.birdChild.name = "小黄雀";
        System.out.println("bird name:" + bird.name);
        System.out.println("bird child name:" + bird.birdChild.name);
        System.out.println("bird name 2:" + bird2.name);
        System.out.println("bird child name 2:" + bird2.birdChild.name);
    }

}

class CloneUtils{
    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;

        try{
            //写入字节流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.close();
            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        }catch (Exception e){

        }
        return cloneObj;
    }
}