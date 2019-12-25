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

    /**
     * test2 find max sum that array([1,2,3,4]) spilt to a new array([1,2][3,4])
     * @author lf
     * @time 2019/12/25 19:59
     */
    @Test
    public void test2() {
        System.out.println(getMaximumSum(new int[]{1, 4, 3, 2, 5, 6}));
    }

    /**
     * get maximum sum
     * @author lf
     * @time 2019/12/25 19:59
     * @param arrays arrays
     * @return int
     */
    private int getMaximumSum(int[] arrays) {
        Arrays.sort(arrays);
        if (arrays.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] - arrays[i - 1] != 1) {
                throw new IllegalArgumentException();
            }
        }
        int sum = 0;
        for (int i = 0; i < arrays.length; i += 2) {
            sum += arrays[i];
        }
        return sum;
    }
}
