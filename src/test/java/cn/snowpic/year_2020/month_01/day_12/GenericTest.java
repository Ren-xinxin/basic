/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.month_01.day_12;

import org.junit.Test;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-12 19:49
     */
    @Test
    public void test1() {
        int[][] input = {
                {4, 3, 8},
                {9, 5, 1},
                {2, 7, 6}
        };
        boolean sudoku = isSudoku(input);
        System.out.println("sudoku = " + sudoku);
    }

    /**
     * is sudoku
     *
     * @author lf
     * @time 2020-01-12 19:52
     * @param input input
     * @return boolean
     */
    private boolean isSudoku(int[][] input) {
        int len = input.length;
        int target = 0;
        int power = 0;
        while (target < len) {
            target = (int) Math.pow(3, ++power);
        }
        if (!(input[0] != null && input.length == input[0].length && input.length == target)) {
            throw new RuntimeException("The specific input is not a sudoku type.");
        }
        int targetSum = 5 * target;
        for (int i = 0; i < input.length; i++) {
            int tep = 0;
            for (int j = 0; j < input[i].length; j++) {
                tep += input[i][j];
            }
            if (tep != targetSum) {
                return false;
            }
            if (i > 0) {
                continue;
            }
            // column
            int tepColumn1 = 0;
            int tepColumn2 = 0;
            for (int k = 0; k < input.length; k++) {
                tepColumn1 += input[0][k];
                tepColumn2 += input[input[0].length - 1][k];
            }
            if (tepColumn1 != targetSum || tepColumn2 != targetSum) {
                return false;
            }
            // tilt
            int row1 = 0;
            int row2 = input[0].length - 1;
            int tepTiltColumn1 = 0;
            int tepTiltColumn2 = 0;
            for (int[] temp : input) {
                tepTiltColumn1 += temp[row1++];
                tepTiltColumn2 += temp[row2--];
            }
            if (tepTiltColumn1 != targetSum || tepTiltColumn2 != targetSum) {
                return false;
            }
        }
        return true;
    }
}
