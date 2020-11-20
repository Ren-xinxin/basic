/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_20;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findDuplicates2(new int[]{1, 2, 3, 1}, 3));
        System.out.println(findDuplicates2(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private boolean findDuplicates2(int[] array, int distance) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            Integer oldIndex = map.get(key);
            if (oldIndex != null) {
                if (i - oldIndex <= distance) {
                    return true;
                } else {
                    map.put(key, i);
                }
            } else {
                map.put(key, i);
            }
        }
        return false;
    }
}
