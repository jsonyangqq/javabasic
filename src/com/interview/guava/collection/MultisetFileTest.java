package com.interview.guava.collection;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * @author jason.yang
 * @Description 真实文件读取测试
 * @Date 2021-09-29 21:11
 */
public class MultisetFileTest {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("alice30.txt");
        List<String> wordList = Files.readAllLines(path);
        List<String> newWordList = Lists.newArrayList();

        wordList.stream().forEach(wordLines -> {
            newWordList.addAll(Arrays.asList(wordLines.split("\\PL+")).stream().collect(Collectors.toList()));
        });

        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(newWordList);
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }

    }

}