/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_24;

import org.junit.Test;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/24 20:20
 */
public class GenericTest {
    /**
     * test1 of max one
     * @author lf
     * @time 2019/12/24 20:30
     */
    @Test
    public void test1() {
        System.out.println(maxOne(new int[]{1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1}));
    }

    /**
     * max one
     * @author lf
     * @time 2019/12/24 20:22
     * @param arrays arrays
     * @return int[]
     */
    private int maxOne(int[] arrays) {
        int max = -1;
        int count = 0;
        for (int array : arrays) {
            if (array == 1) {
                max = Math.max(max, ++count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    @Test
    public void test2() {
        System.out.println(findKDiff(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(findKDiff(new int[]{3, 1, 4, 1, 5}, 2));
    }

    /**
     * find k diff
     * @author lf
     * @time 2019/12/24 20:34
     * @param arrays arrays
     * @param k k
     * @return int
     */
    private int findKDiff(int[] arrays, int k) {
        if (k == 0) {
            throw new IllegalArgumentException("k must greater than 0");
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int array : arrays) {
            hashSet.add(array);
        }
        AtomicInteger count = new AtomicInteger();
        hashSet.forEach(a -> {
            int abs1 = a + k;
            int abs2 = a - k;
            if (hashSet.contains(abs1)) {
                count.getAndIncrement();
            }
            if (hashSet.contains(abs2)) {
                count.getAndIncrement();
            }
        });
        return count.get() / 2;
    }
}
