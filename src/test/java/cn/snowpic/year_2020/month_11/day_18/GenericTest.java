/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_18;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(array, 3);
        System.out.println(Arrays.toString(array));
        rotateArray(array, 4);
        System.out.println(Arrays.toString(array));
    }

    /**
     * rotate array
     *
     * @author Little Flower
     * @date 2020-11-18 22:49:21
     * @param array array
     */
    private void rotateArray(int[] array, int steps) {
        int len = array.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + steps) % len] = array[i];
        }
        System.arraycopy(temp, 0, array, 0, len);
    }
}
