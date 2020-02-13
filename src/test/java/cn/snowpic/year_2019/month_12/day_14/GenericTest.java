/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.month_12.day_14;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/14 0:30
 */
public class GenericTest {

    @Test
    public void test1() {
        int[] addOne = addOne(new int[]{9, 9, 9, 9});
        System.out.println(Arrays.toString(addOne));
    }

    /**
     * add one
     * @author lf
     * @time 2019/12/14 0:38
     * @param arrays arrays
     * @return int[]
     */
    private int[] addOne(int[] arrays) {
        arrays[arrays.length - 1]++;
        int high = 0;
        for (int i = arrays.length - 1; i >= 0; i--) {
            int origin = arrays[i] + high;
            arrays[i] = origin % 10;
            high = origin / 10;
        }
        if (high > 0) {
            int[] result = new int[arrays.length + 1];
            result[0] = high;
            System.arraycopy(arrays, 0, result, 1, arrays.length);
            return result;
        }
        return arrays;
    }
}
