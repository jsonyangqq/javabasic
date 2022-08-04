package com.interview.datamodel;

import lombok.extern.slf4j.Slf4j;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-07-09 10:27
 */
public class Ssm {



    public static void main(String[] args) {
        String url = "xxx";
        String encode = URLEncoder.encode(url);
        System.out.println("URL编码结果：" + encode);
        String decode = URLDecoder.decode(encode);
        System.out.println("URL解码结果：" + decode);
    }

}