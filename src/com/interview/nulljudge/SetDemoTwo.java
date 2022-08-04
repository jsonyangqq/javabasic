package com.interview.nulljudge;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-07-11 16:04
 */
@Slf4j
public class SetDemoTwo {

    private static EasyRandom easyRandom = new EasyRandom();

    public static void main(String[] args) {

        // 构造测试数据
        PmsBrand pmsBrand = easyRandom.nextObject(PmsBrand.class);
        System.out.println(JSON.toJSONString(pmsBrand));

        log.info("构造的数据:{}", JSON.toJSONString(pmsBrand));

    }

}