/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_26;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/26 22:37
 */
public class GenericTest {

    @Test
    public void test1() {
        int[][] origin = {{1, 2, 3, 4}};
        int[][] reshape = reshape(origin, 4, 1);
        // System.out.println("reshape = " + Arrays.toString(reshape));
        for (int[] shape : reshape) {
            System.out.println(Arrays.toString(shape));
        }
    }


    /**
     * reshape
     * @author lf
     * @time 2019/12/26 22:40
     * @param arrays arrays
     * @param row row
     * @param column column
     * @return int[][]
     */
    private int[][] reshape(int[][] arrays, int row, int column) {
        int r1 = arrays.length;
        int c1 = arrays[0].length;
        if (r1 * c1 > row * column) {
            throw new RuntimeException("Unsupported row and column..");
        }
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // one line index
                int index = i * column + j;
                result[i][j] = arrays[index / c1][index % c1];
            }
        }
        return result;
    }
}
