/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.day_09;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/9 21:47
 */
public class GenericTest {

    /**
     * remove duplicated elements
     * @author lf
     * @time 2019/12/9 21:48
     */
    @Test
    public void test1() {
        int[] arrays = new int[]{2, 3, 6, 5, 35, 23, 7, 3, 2, 22, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 66, 7};
        bubbleSort(arrays);
        System.out.println(Arrays.toString(arrays));
        System.out.println(Arrays.toString(removeDuplicatedElements(arrays)));
    }

    /**
     * remove duplicated elements
     * @author lf
     * @time 2019/12/9 22:02
     * @param arrays arrays
     * @return int[]
     */
    public int[] removeDuplicatedElements(int[] arrays) {
        int i = 0;
        for (int j = 1; j < arrays.length; j++) {
            if (arrays[j] != arrays[i]) {
                arrays[++i] = arrays[j];
            }
        }
        int[] result = new int[i + 1];
        System.arraycopy(arrays, 0, result, 0, i + 1);
        return result;
    }

    /**
     * bubble sort time complexity O(N^2)
     * @author lf
     * @time 2019/12/9 22:05
     * @param arrays arrays
     */
    private void bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < (arrays.length - 1) - i; j++) {
                if (arrays[j] < arrays[j + 1]) {
                    int tem = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = tem;
                }
            }
        }
    }

    /**
     * remove target value from an array
     * @author lf
     * @time 2019/12/10 0:04
     */
    @Test
    public void test3() {
        int[] arrays = new int[]{2, 3, 6, 5, 35, 23, 7, 3, 2, 22, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 66, 7};
        System.out.println(Arrays.toString(rmTarget(arrays, 7)));
    }

    /**
     * rm target
     * @author lf
     * @time 2019/12/10 0:03
     * @param arrays arrays
     * @param target target
     * @return int[]
     */
    private int[] rmTarget(int[] arrays, int target) {
        int i = 0;
        for (int j = 0; j < arrays.length; j++) {
            if (arrays[j] != target) {
                arrays[i++] = arrays[j];
            }
        }
        int[] result = new int[i];
        System.arraycopy(arrays, 0, result, 0, i);
        return result;
    }
}