/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_16;

import org.junit.Test;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-16 0:08
     */
    @Test
    public void test1() {
        int[] array = {1, 2, 2, 3};
        boolean monotonic = monotonic(array);
        System.out.println("monotonic = " + monotonic);
    }

    /**
     * monotonic
     *
     * @author lf
     * @time 2020-01-16 0:13
     * @param array array
     * @return boolean
     */
    private boolean monotonic(int[] array) {
        return increasing(array) || decreasing(array);
    }

    /**
     * increasing
     *
     * @author lf
     * @time 2020-01-16 0:12
     * @param array array
     * @return boolean
     */
    private boolean increasing(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * decreasing
     *
     * @author lf
     * @time 2020-01-16 0:12
     * @param array array
     * @return boolean
     */
    private boolean decreasing(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
