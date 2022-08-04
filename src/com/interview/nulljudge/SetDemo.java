package com.interview.nulljudge;



import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.jeasy.random.randomizers.collection.ListRandomizer;
import org.jeasy.random.randomizers.text.StringRandomizer;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-07-09 17:14
 */
@Slf4j
public class SetDemo {

    public static void main(String[] args) {

        List<Integer> lengthList = new LinkedList<>();
        int base = 1;
        for (int i = 1; i <= 6; i++) {
            base *= 10;
            lengthList.add(base);
        }

        StringRandomizer stringRandomizer = new StringRandomizer(10, 100, 1000);

        for (Integer length : lengthList) {
            log.debug("------------长度为 {} 时-------", length);
            ListRandomizer<String> listRandomizer = new ListRandomizer<>(stringRandomizer, length);
            List<String> data = listRandomizer.getRandomValue();

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Set<String> resultBySet = CollectionUtil.removeDuplicateBySet(data);
            log.debug("set去重耗时：{} ms", stopWatch.getTime());

//            stopWatch = new StopWatch();
//            stopWatch.start();
//            List<String> strings1 = CollectionUtil.removeDuplicateByList(data);
//            log.debug("普通list去重耗时：{} ms", stopWatch.getTime());

            stopWatch = new StopWatch();
            stopWatch.start();
            List<String> strings = data.stream().distinct().collect(Collectors.toList());
            log.debug("Lambda表达式list去重耗时：{} ms", stopWatch.getTime());
        }

    }

}