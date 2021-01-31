/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_01.day_31;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenericTest {

    @Test
    public void test1() {
        int count = findConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(count);
    }

    private int findConsecutiveOnes(int[] array) {
        int count = 0;
        int max = 0;
        for (int i : array) {
            if (i == 0) {
                count = 0;
            } else {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    @Test
    public void test2() {
        int num = findKDiffPairs(new int[]{3, 1, 4, 1, 5,}, 2);
        System.out.println(num);
        System.out.println(findKDiffPairs(new int[]{1, 2, 3, 4, 5,}, 1));
        System.out.println(findKDiffPairs(new int[]{1, 3, 1, 5, 4,}, 0));

        System.out.println(findKDiffPairs2(new int[]{3, 1, 4, 1, 5,}, 2));
        System.out.println(findKDiffPairs2(new int[]{1, 2, 3, 4, 5,}, 1));
        System.out.println(findKDiffPairs2(new int[]{1, 3, 1, 5, 4,}, 0));
    }

    private int findKDiffPairs(int[] array, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            Set<Integer> value = map.get(key);
            if (value == null) {
                value = new HashSet<>();
            }
            value.add(i);
            map.put(key, value);
        }
        int count = 0;
        for (Integer integer : map.keySet()) {
            int key = integer + k;
            Set<Integer> value = map.get(key);
            if (k == 0) {
                if (value.size() > 1) {
                    count++;
                }
                continue;
            }
            if (value != null) {
                count++;
            }
        }
        return count;
    }

    private int findKDiffPairs2(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.merge(i, 1, Integer::sum);
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            key += k;
            Integer value = map.get(key);
            if (value != null) {
                if (k == 0 && value > 1) {
                    count++;
                }
                if (k != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test3() {
        int sum = getMaxSum(new int[]{1, 4, 3, 2});
        System.out.println(sum);
    }

    private int getMaxSum(int[] array) {
        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];

        }
        return sum;
    }
}
