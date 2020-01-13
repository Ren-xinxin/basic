/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_13;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-13 20:36
     */
    @Test
    public void test1() {
        int[][] before = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] after = transpose(before);
        System.out.println("after = " + Arrays.deepToString(after));
    }

    /**
     * transpose
     *
     * @author lf
     * @time 2020-01-13 20:34
     * @param arrays arrays
     * @return int[][]
     */
    private int[][] transpose(int[][] arrays) {
        int row = arrays.length;
        int column = arrays[0].length;
        int[][] result = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = arrays[i][j];
            }
        }
        return result;
    }
}
