package com.interview.wide.io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.google.gson.Gson;
import com.interview.entity.User;

import java.io.*;
import java.math.BigDecimal;

/**
 * @author json.yang
 * @Description 多种方式进行序列化
 * @Date 2020-01-08
 */
public class SerializableWay {

    /**
     * 方式1：通过原生方式进行序列化
     * @throws Exception
     */
    public void protogeSerializable() throws Exception {
        //对象
//        User user = new User();
//        user.setName("张三");
//        user.setAge(20);
//        System.out.println(user);
//        //创建文件输出流(因为是要写入磁盘)
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.out"));
//        //序列化对象到内存磁盘
//        oos.writeObject(user);
        //从磁盘反序列化出来
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.out"));
        //反序列化
        User o = (User) ois.readObject();
        ois.close();
        System.out.println(o);
//        System.out.println("user==user1 => "+(user==o));
    }

    /**
     * json格式，使用fastjson或者GSON序列化方式进行序列化
     * @throws Exception
     */
    public void fastJsonSerializable() throws Exception {
        // 对象赋值
        User user = new User();
        user.setName("老王");
        user.setAge(30);
        System.out.println(user);
        System.out.println("------------------------ 第一种json格式序列化 ------------------------");
        String jsonSerializable = JSON.toJSONString(user);
        User user1 = (User) JSON.parseObject(jsonSerializable,User.class);
        System.out.println(user1);
        System.out.println("user==user1 => "+(user==user1));
        System.out.println("------------------------ 第二种json格式序列化 ------------------------");
        Gson gson = new Gson();
        String gsonSerializable = gson.toJson(user);
        User user2 = gson.fromJson(gsonSerializable, User.class);
        System.out.println(user2);
        System.out.println("user==user2 => "+(user==user2));
    }

    /**
     * Hessian 方式序列化
     */
    public void hessionSerializable() throws Exception {
        // 对象赋值
        User user = new User();
        user.setName("老王");
        user.setAge(30);
        System.out.println(user);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(bo);
        hessianOutput.writeObject(user);
        byte[] bytes = bo.toByteArray();
        //反序列化
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        HessianInput hessianInput = new HessianInput(bi);
        User o = (User) hessianInput.readObject();
        System.out.println(o);
    }







}