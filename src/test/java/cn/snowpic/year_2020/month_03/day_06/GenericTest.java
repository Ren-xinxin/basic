/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_06;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-03-06 22:16:35
 */
public class GenericTest {

    /**
     * get increased height
     *
     * @author lf
     * @time 2020-03-06 22:41:05
     * @param gird gird
     * @return int
     */
    private int getIncreasedHeight(int[][] gird) {
        int len = gird.length;
        int[] horizontal = new int[len], vertical = new int[len];
        for (int i = 0; i < len; i++) {
            int maxHorizontal = Integer.MIN_VALUE;
            int maxVertical = Integer.MIN_VALUE;
            for (int j : gird[i]) {
                maxHorizontal = Math.max(maxHorizontal, j);
            }
            horizontal[i] = maxHorizontal;
            for (int[] column : gird) {
                maxVertical = Math.max(maxVertical, column[i]);
            }
            vertical[i] = maxVertical;
        }
        int result = 0;
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[i].length; j++) {
                int max = Math.min(horizontal[j], vertical[i]);
                result += max - gird[i][j];
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[][] gird = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        int increasedHeight = getIncreasedHeight(gird);
        System.out.println("increasedHeight = " + increasedHeight);
    }
}
