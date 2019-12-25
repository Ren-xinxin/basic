/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_25;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/25 18:58
 */
public class GenericTest {

    /**
     * test1 of find unSort sub array of the specific array
     * @author lf
     * @time 2019/12/25 18:59
     */
    @Test
    public void test1() {
        int[] unSortSubArray = findUnSortSubArray(new int[]{2, 6, 4, 8, 10, 9, 15});
        System.out.println("unSortSubArray = " + Arrays.toString(unSortSubArray));
    }

    /**
     * find un sort sub array
     * @author lf
     * @time 2019/12/25 19:04
     * @param arrays arrays
     * @return int[]
     */
    private int[] findUnSortSubArray(int[] arrays) {
        int[] clone = arrays.clone();
        Arrays.sort(clone);
        int start = arrays.length - 1;
        int stop = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != clone[i]) {
                start = Math.min(i, start);
                stop = Math.max(i, stop);
            }
        }
        int[] result = new int[stop - start + 1];
        System.arraycopy(arrays, start, result, 0, result.length);
        return result;
    }
}
