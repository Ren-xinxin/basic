/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_07;

import org.junit.Test;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(checkNonDecreasingArray(new int[]{4, 2, 3}));
        System.out.println(checkNonDecreasingArray(new int[]{4, 2, 1}));
    }

    private boolean checkNonDecreasingArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
