package com.interview.arithmetic.nodeformat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-05-16 17:33
 */
public class TestJsonParse {

    public static void main(String[] args) {
        String str = "{\n" +
                "    \"path\": \"level0_0\",\n" +
                "    \"value\": \"value\",\n" +
                "    \"children\": [\n" +
                "        {\n" +
                "            \"path\": \"level0_0/level1_0\",\n" +
                "            \"value\": \"value\",\n" +
                "            \"children\": []\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Node nodes = JSONObject.parseObject(str, Node.class);
        List<Node> level0_0 = NodeUtils.getNode(Lists.newArrayList(nodes), "level0_0");
        System.out.println(JSON.toJSONString(level0_0));

    }

}