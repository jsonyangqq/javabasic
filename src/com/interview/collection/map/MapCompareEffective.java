package com.interview.collection.map;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author jason.yang
 * @Description map集合效率对比
 * @Date 2021-03-18 17:52
 */
public class MapCompareEffective {

    public static void main(String[] args) {
//        long caculateTotalCount = 10000;
//        testHashTable(caculateTotalCount);
        Integer i = 1;
        System.out.println("1".equals(i));

        String[] bigStr = {"92391038655","92391038654","92391038640","92391038648","92391038647","92391038646","92391038645","92391038643","92391038699","92391038856","92391038877","82391038527","92391038882","92391038881","92391038584","92391038508","82391038569","82391038571","92391438411","92391538969","82391038551","82391038559","92391038501","92391038506","92391038638","92391038599","92391038644","82391738052","82391738994","82391738053","82391738045","82391738991","82391038549","82391038566","82391038545","82391038544","82391738993","82391738043","92391738236","92391738237","92391738239","92391738241","92391738243","92391738244","92391838636","82391838644","82391838645","82391838646","82391838647","82391838648","82391838640","82391838652","82391838653","82391838657","82391838659","82391838661","92391838847","92391039406","92391139382","92391339994","92391439529","92391439855","92391539874","92391839985","92391839635","92391939449","92391939457","92391030512","92391230117","92391530398","92391630119","92391331707","92391331859","92391331861","92391331858","92391431718","92391431155","92391431205","92391231723","92391631884","92391631978","92391138765","92391731167","92391931044","92391931895","92391032603","92391032699","92391532832","92391532831","92391532765","92391532768","92391532760","92391532771","92391532773","92391532775","92391532783","92391532784","92391532786","92391532787","92391532973","92391532972","92391732068","92391732067","92391732711","92391732708","92391139788","92391139784"};
        System.out.println(bigStr.length);


        String str = "{\"header\":[[\"id\",\"business_type\",\"business_key\",\"business_ext\",\"update_user\",\"create_time\",\"update_time\",\"remark\",\"delay_day\",\"invalid_time\",\"is_delete\"]],\"data\":[{\"id\":21816,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391231723,\"business_ext\":\"N\",\"update_user\":\"p_zhitong\",\"create_time\":\"2021-06-10 20:03:43\",\"update_time\":\"2021-06-10 20:09:46\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21805,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391138765,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-10 17:02:28\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21759,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391431205,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:58:09\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21743,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391431155,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:56:49\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21704,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391431718,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:55:34\",\"update_time\":\"2021-06-23 18:21:10\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21640,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391331707,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:52:40\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21429,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391530398,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:52:04\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21454,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391630119,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:52:04\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21316,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391230117,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:50:15\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21157,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391839635,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:43:59\",\"update_time\":\"2021-06-23 18:21:10\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21162,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391839985,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:43:59\",\"update_time\":\"2021-06-23 18:21:10\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21017,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391339994,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 23:42:31\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21814,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391631884,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 22:58:45\",\"update_time\":\"2021-06-03 22:58:45\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":20723,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391838847,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 22:58:45\",\"update_time\":\"2021-06-23 18:21:10\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":20463,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391438411,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 22:58:22\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":20004,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391038877,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 22:57:48\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":21813,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391631978,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 22:57:48\",\"update_time\":\"2021-06-03 22:57:48\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":19831,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391038699,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 22:57:28\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0},{\"id\":19893,\"business_type\":\"posAgentNoBlacklist\",\"business_key\":92391038856,\"business_ext\":\"N\",\"update_user\":\"lepos002\",\"create_time\":\"2021-06-03 22:57:28\",\"update_time\":\"2021-06-10 19:22:03\",\"remark\":\"\",\"delay_day\":0,\"invalid_time\":\"-\",\"is_delete\":0}]}";
        HashMap map = JSONObject.parseObject(str, new HashMap<String, Object>().getClass());
        List<Map<String, Object>> data = (List<Map<String, Object>>) map.get("data");
        List<Object> business_keys = data.stream().map(map1 -> map1.get("business_key")).collect(Collectors.toList());
        System.out.println(business_keys);

    }

    public static void testHashTable(long caculateTotalCount) {
//        Hashtable<Integer, String> map = new Hashtable<>();
//        long startMills = System.currentTimeMillis();
//        for (int i = 0; i < caculateTotalCount; i++) {
//            map.put(i,randomKey());
//        }
//        long endMills = System.currentTimeMillis();
//        System.out.println("开始时间："+startMills);
//        System.out.println("结束时间："+endMills);
//        System.out.println("总共用时："+(endMills - startMills) + "ms");

        String posSnEnd = "sn64755";
        char[] chars = posSnEnd.toCharArray();
        StringBuilder prefixSb = new StringBuilder();
        //先读取字符
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        for (char aChar : chars) {
            String shortChar = String.valueOf(aChar);
            if(pattern.matcher(shortChar).matches()) {
                prefixSb.append(shortChar);
                continue;
            }
            break;
        }
        System.out.println(prefixSb.toString());

        String newStr = posSnEnd.replaceAll(prefixSb.toString(), "");
        System.out.println(Long.parseLong(newStr));



    }

    public static void testConcurrentMap(long caculateTotalCount) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        long startMills = System.currentTimeMillis();
        for (int i = 0; i < caculateTotalCount; i++) {
            map.put(i,randomKey());
        }
        long endMills = System.currentTimeMillis();
        System.out.println("开始时间："+startMills);
        System.out.println("结束时间："+endMills);
        System.out.println("总共用时："+(endMills - startMills) + "ms");
    }

    public static String randomKey() {
        Random random = new Random();
        String[] letters = new String[]{"a","b","c","d","e","f","g","h","i","j","k","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String randomKey = "";
        for (int i = 0; i < 10; i++) {
            randomKey += letters[random.nextInt(letters.length-1)];
        }
        return randomKey;
    }

}