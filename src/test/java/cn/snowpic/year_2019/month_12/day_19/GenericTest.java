/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.month_12.day_19;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/19 23:20
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/12/19 23:28
     */
    @Test
    public void test1() {
        System.out.println(duplicated(new int[]{1, 2, 3, 1}, 3));
        System.out.println(duplicated(new int[]{1, 0, 1, 1}, 1));
        System.out.println(duplicated(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    /**
     * duplicated
     * @author lf
     * @time 2019/12/19 23:28
     * @param arrays arrays
     * @param k k
     * @return boolean
     */
    private boolean duplicated(int[] arrays, int k) {
        Map<Integer, Integer> temp = new HashMap<>(arrays.length * 3 / 4);
        for (int i = 0; i < arrays.length; i++) {
            Integer old = temp.put(arrays[i], i);
            if (old != null && i - old <= k) {
                return true;
            }
        }
        return false;
    }
}
