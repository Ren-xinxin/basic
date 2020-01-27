/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_27;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-27 11:41
     */
    @Test
    public void test1() {
        int[] array = {5, 7, 8, 8, 10};
        int[] range1 = findRange(array, 8);
        int[] range2 = findRange(array, 6);

        System.out.println("range2 = " + Arrays.toString(range1));
        System.out.println("range2 = " + Arrays.toString(range2));
    }

    /**
     * find range
     *
     * @author lf
     * @time 2020-01-27 11:46
     * @param array array
     * @param target target
     * @return int[]
     */
    private int[] findRange(int[] array, int target) {
        int[] result = {-1, -1};
        boolean isStart = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                if (isStart) {
                    isStart = false;
                    result[0] = i + 1;
                }
                result[1] = i + 1;
            }
        }
        return result;
    }
}
