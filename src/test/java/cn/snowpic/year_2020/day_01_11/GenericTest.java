/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_11;

import org.junit.Test;

/**
 * generic test
 * @className GenericTest
 * @author lf
 * @time 2020-01-11 14:03
 */
public class GenericTest {

    @Test
    public void test1() {
        int[][] toeplitz1 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        };
        boolean toeplitz = toeplitz(toeplitz1);
        System.out.println("toeplitz = " + toeplitz);
    }

    /**
     * toeplitz
     * @author lf
     * @time 2020-01-11 20:52
     * @param arrays arrays
     * @return boolean
     */
    private boolean toeplitz(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            if (isToeplitz(arrays, i, 0)) {
                return false;
            }
            if (i > 0) {
                continue;
            }
            for (int j = 1; j < arrays[i].length; j++) {
                if (isToeplitz(arrays, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * is toeplitz
     *
     * @author lf
     * @time 2020-01-11 21:11
     * @param arrays arrays
     * @param row row
     * @param column column
     * @return boolean
     */
    private boolean isToeplitz(int[][] arrays, int row, int column) {
        int sameVal;
        sameVal = arrays[row][column];
        int tepI = row;
        int tepJ = column;
        while (++tepI < arrays.length && ++tepJ < arrays[row].length) {
            if (arrays[tepI][tepJ] != sameVal) {
                return true;
            }
        }
        return false;
    }
}
