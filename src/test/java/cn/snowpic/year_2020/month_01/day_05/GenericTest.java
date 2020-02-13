/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.month_01.day_05;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2020/1/5 22:27
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2020/1/5 22:47
     */
    @Test
    public void test1() {
        int[] array = {1, 2, 2, 3, 1};
        int subArray = findShortestSubArray(array);
        System.out.println("subArray = " + subArray);
    }

    /**
     * find shortest sub array
     * @author lf
     * @time 2020/1/5 22:32
     * @param array array
     * @return int
     */
    private int findShortestSubArray(int[] array) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : array) {
            Integer v1 = counter.get(i);
            Integer value = (v1 == null ? 1 : ++v1);
            counter.put(i, value);
        }
        AtomicInteger familiar = new AtomicInteger();
        AtomicInteger degree = new AtomicInteger();
        counter.forEach((k, v) -> {
            if (v > degree.get()) {
                familiar.set(k);
                degree.set(v);
            }
        });
        Set<Integer> familiars = new HashSet<>();
        // ensure all familiars was picked
        counter.forEach((k, v) -> {
            if (v == degree.get()) {
                familiars.add(k);
            }
        });
        AtomicInteger minPath = new AtomicInteger(Integer.MAX_VALUE);
        familiars.forEach(f -> {
            int start = -1;
            int stop = -1;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == f) {
                    if (start == -1) {
                        start = i;
                    } else {
                        stop = i;
                    }
                }
            }
            // stop - start + 1 sub array's length
            minPath.set(Math.min(minPath.get(), stop - start + 1));
        });
        return minPath.get();
    }
}
