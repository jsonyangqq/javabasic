package com.interview.javabasic.enums;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-10-11 21:59
 */
public class FeatureUtilTest {

    private int features;

    @Before
    public void init() {
        features = FeatureUtil.of(DemoEnum.values());
    }

    @Test
    public void isEnabled() {
        boolean enabledFirst = FeatureUtil.isEnabled(features, DemoEnum.FIRST);
        boolean enabledSecond = FeatureUtil.isEnabled(features, DemoEnum.SECOND);
        Assert.assertTrue(enabledFirst);
        Assert.assertTrue(enabledSecond);
    }

    @Test
    public void config() {
        int defaultFeature = 0;
        int enableFirst = FeatureUtil.config(defaultFeature, DemoEnum.FIRST, true);
        int enableFirst2 = FeatureUtil.of(DemoEnum.FIRST);
        Assert.assertEquals(enableFirst, enableFirst2);
    }

    @Test
    public void of() {
        // 前两个特性
        int two = FeatureUtil.of(DemoEnum.FIRST, DemoEnum.SECOND);
        Assert.assertEquals(two, 3);

        // 后两个特性
        int lastTwo = FeatureUtil.of(DemoEnum.THIRD, DemoEnum.SECOND);
        Assert.assertEquals(lastTwo, 6);

    }

    @Test
    public void resolve() {
        int features = FeatureUtil.of(DemoEnum.FIRST, DemoEnum.SECOND);
        Set<Feature> resolve = FeatureUtil.resolve(features, DemoEnum.values());

        Assert.assertEquals(resolve.size(), 1);
        Assert.assertTrue(resolve.contains(DemoEnum.FIRST));
        Assert.assertTrue(resolve.contains(DemoEnum.THIRD));

    }

    @Test
    public void containsFeatures() {
        int features = FeatureUtil.of(DemoEnum.FIRST, DemoEnum.SECOND);
        boolean flag = FeatureUtil.containsFeatures(features, DemoEnum.values());
        Assert.assertTrue(flag);

    }

}