package com.interview.io;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author jason.yang
 * @Description 写入数据到文件
 * @Date 2021-12-30 15:24
 */
public class WriteDataAsFile {

    public static void main(String[] args) {
        Path fpath = Paths.get("possn1.txt");
        //创建文件
        if(!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //创建BufferedWriter
        try {
            BufferedWriter bfw= Files.newBufferedWriter(fpath);
            Faker faker = Faker.instance();
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            for (int i = 0; i < 100000; i++) {
                bfw.write(faker.number().randomNumber(10, true) + ",");
            }
            bfw.flush();
            bfw.close();
            System.out.println("总共用时:" + stopWatch.getTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}