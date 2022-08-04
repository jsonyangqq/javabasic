package com.interview.io;

import com.interview.common.DateUtil;

import java.io.File;
import java.util.Date;

/**
 * @author json.yang
 * @Description 文件操作测试
 * @Date 2020-01-11
 */
public class FileOperatorTest {

    public static void main(String[] args) {
        String newName = "abc.txt";
        String filePath = DateUtil.formatDate(new Date(),"/yyyy/MM/dd");
        File targetFile = new File("E:\\tomcatCache\\image\\home\\RlandTelecomFtp\\images"+filePath,newName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        System.out.println("创建成功！");
    }

}