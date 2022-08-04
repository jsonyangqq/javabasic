package com.interview.javabasic.mybatisrelation;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-12-13 21:08
 */
public class TestHashCode {

    public static void main(String[] args) {

        CacheKey cacheKey = new CacheKey();
        cacheKey.update("com.gupaoedu.mapper.BlogMapper.selectBlogById");
        cacheKey.update(0);
        cacheKey.update(2147483647);
        cacheKey.update("select * from blog where bid = ?");
        cacheKey.update(1);
        cacheKey.update("development");
        System.out.println(cacheKey);


        CacheKey cacheKey2 = new CacheKey();
        cacheKey2.update("com.gupaoedu.mapper.BlogMapper.selectBlogById");
        cacheKey2.update(0);
        cacheKey2.update(2147483647);
        cacheKey2.update("select * from blog where bid = ?");
        cacheKey2.update(1);
        cacheKey2.update("development");
        System.out.println(cacheKey2);

        System.out.println(cacheKey == cacheKey2);



    }

}