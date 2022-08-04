package com.interview.io;

import com.github.javafaker.Faker;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-12-30 11:37
 */
@Slf4j
public class ReadFileAsList {

    public static void main(String[] args) {
//        m1();
//        m2();
//        m3();
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        BigDecimal d = new BigDecimal(3);
        BigDecimal bigDecimal = Optional.ofNullable(d).orElse(BigDecimal.ZERO);
        System.out.println(bigDecimal);
    }

    private static void m2() {
        try {
            List<String> resultLists = Files.readAllLines(Paths.get("possnResult.txt"));
            List<String> strings = Files.readAllLines(Paths.get("possn2.txt"));
            strings = strings.stream().filter(str -> StringUtils.isNoneBlank(str)).collect(Collectors.toList());

            System.out.println(strings.size());
            resultLists.stream().forEach(posSnResult -> {

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void m1() {
        try {
            List<String> posSnList = Files.readAllLines(Paths.get("possn2.txt")); //要排除的数据
            System.out.println(posSnList.size());
            BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 150000, 0.0000001);
            posSnList.stream().forEach(posSn -> {
                bloomFilter.put(posSn);
            });

            List<String> list = Files.readAllLines(Paths.get("possnResult.txt"));
//            List<String> list = Arrays.asList(new String[]
//                    {"2202947494", "2486621766", "6911796822", "5731830154", "8149228181", "32784972"});
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            AtomicInteger atomicInteger  = new AtomicInteger();
            Iterator<String> iterator = list.iterator();
            System.out.println(list.size());
            while (iterator.hasNext()) {
                String posSn = iterator.next();
                if(bloomFilter.mightContain(posSn)) {
                    System.out.println(posSn);
                    atomicInteger.incrementAndGet();
                    iterator.remove();
                }
            }
            System.out.println(atomicInteger.getAndIncrement());
            System.out.println(list.size());
            log.info("执行耗时：{} ms", stopWatch.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void m3() {
        try {
            List<String> posSnList = Files.readAllLines(Paths.get("possn2.txt")); //要排除的数据
            System.out.println(posSnList.size());
            BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 3447, 0.0000001);
            posSnList.stream().forEach(posSn -> {
                bloomFilter.put(posSn);
            });
            List<String> list = Files.readAllLines(Paths.get("possnResult.txt"));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            AtomicInteger atomicInteger  = new AtomicInteger();
            Iterator<String> iterator = list.iterator();
            System.out.println(list.size());
            while (iterator.hasNext()) {
                String posSn = iterator.next();
                if(bloomFilter.mightContain(posSn)) { //校验是否两边都包含
                    System.out.println(posSn);
                    atomicInteger.incrementAndGet();
                    iterator.remove();
                }
            }
            System.out.println(atomicInteger.getAndIncrement());
            System.out.println(list.size());
            log.info("执行耗时：{} ms", stopWatch.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}