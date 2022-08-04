package com.interview.pecs;

import com.google.common.collect.ImmutableSet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author json.yang
 * @Description
 * @Date 2020-07-09
 */
public class GernerTypes {

//    public static void  method(List<Integer> list) {
//        System.out.println("List<Integer> list");
//    }
    public static void method(List<String> list) {
        System.out.println("List<String> list");
    }

    public static void main(String[] args) throws IOException {
        String url1 = "https://www.codota.com";
        URL url = new URL(url1);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int stats = httpURLConnection.getResponseCode();
        if(stats == 200) {

        }

    }


}