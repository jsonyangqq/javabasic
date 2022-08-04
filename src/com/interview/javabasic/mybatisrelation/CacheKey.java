package com.interview.javabasic.mybatisrelation;


import org.apache.ibatis.reflection.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-12-13 21:01
 */
public class CacheKey {

    // 8/21/2017 - Sonarlint flags this as needing to be marked transient.
    // While true if content is not serializable, this is not always true and thus should not be marked transient.
    private List<Object> updateList;

    private final int multiplier;

    private int hashcode;

    private int count;

    private long checksum;

    private static final int DEFAULT_MULTIPLIER = 37;
    private static final int DEFAULT_HASHCODE = 17;

    public CacheKey() {
        this.hashcode = DEFAULT_HASHCODE;
        this.multiplier = DEFAULT_MULTIPLIER;
        this.count = 0;
        this.updateList = new ArrayList<>();
    }

    public void update(Object object) {
        // 加法哈希
        int baseHashCode = object == null ? 1 : ArrayUtil.hashCode(object);
        count++;
        checksum += baseHashCode;
        baseHashCode *= count;

        hashcode = multiplier * hashcode + baseHashCode;

        updateList.add(object);
    }

    @Override
    public boolean equals(Object object) {
        // 同一个对象
        if (this == object) {
            return true;
        }
        // 被比较的对象不是 CacheKey
        if (!(object instanceof CacheKey)) {
            return false;
        }

        final CacheKey cacheKey = (CacheKey) object;

        // hashcode 不相等
        if (hashcode != cacheKey.hashcode) {
            return false;
        }
        // checksum 不相等
        if (checksum != cacheKey.checksum) {
            return false;
        }
        // count 不相等
        if (count != cacheKey.count) {
            return false;
        }

        for (int i = 0; i < updateList.size(); i++) {
            Object thisObject = updateList.get(i);
            Object thatObject = cacheKey.updateList.get(i);
            if (!ArrayUtil.equals(thisObject, thatObject)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return hashcode;
    }

    @Override
    public String toString() {
        StringJoiner returnValue = new StringJoiner(":");
        returnValue.add(String.valueOf(hashcode));
        returnValue.add(String.valueOf(checksum));
        updateList.stream().map(ArrayUtil::toString).forEach(returnValue::add);
        return returnValue.toString();
    }

}