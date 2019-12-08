/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_12_08;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/8 21:19
 */
public class GenericTest {

    @Test
    public void test1() {
        int[] list = {1, 3, 5, 7, 8, 10, 12};
        int target = 20;
        int[] result = getSum(list, target);
        System.out.println("result = " + Arrays.toString(result));
    }

    private int[] getSum(int[] list, int target) {
        for (int i = 0; i < list.length; i++) {
            int other = target - list[i];
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] == other) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
