package com.interview.javabasic.exception;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author json.yang
 * @Description fd
 * @Date 2019-09-24
 */
public class ExcptionUsage {

    public static void main(String[] args) {
        //try-catch可能会引起不必要的性能开销,所以我们尽量避免使用，建议只在需要try-catch包裹的地方进行包裹
//        JSONArray array = new JSONArray();
//        String jsonStr = "{'name':'laowang'}";
//        try {
//            array = JSONArray.parseArray(jsonStr);
//        } catch (Exception e) {
//            array.add(JSONObject.parse(jsonStr));
//        }
//        System.out.println(array.size());

        // 使用 com.alibaba.fastjson
        JSONArray array = new JSONArray();
        String jsonStr = "{'name':'laowang'}";
        if (null != jsonStr && !jsonStr.equals("")) {
            String firstChar = jsonStr.substring(0, 1);
            if (firstChar.equals("{")) {
                array.add(JSONObject.parse(jsonStr));
            } else if (firstChar.equals("[")) {
                array = JSONArray.parseArray(jsonStr);
            }
        }
        System.out.println(array);

    }

}