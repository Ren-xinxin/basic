/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_01.day_13;

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

    /**
     * test2
     *
     * @author lf
     * @time 2020-01-13 21:00
     */
    @Test
    public void test2() {
        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        int maxNearby = maxNeighbor(seats);
        System.out.println("maxNearby = " + maxNearby);

        int[] seats2 = {1, 0, 0, 0};
        int maxNearby1 = maxNeighbor(seats2);
        System.out.println("maxNearby1 = " + maxNearby1);
    }

    /**
     * max nearby
     *
     * @author lf
     * @time 2020-01-13 21:02
     * @param seats seats
     * @return int
     */
    private int maxNearby(int[] seats) {
        int max = 0;
        boolean flag1 = seats[0] == 0;
        boolean flag2 = seats[seats.length - 1] == 0;
        int tep = 0;
        for (int i = 0; i < seats.length; i++) {
            if (i == seats.length - 1) {
                if (flag2) {
                    max = Math.max(max, tep + 1);
                } else {
                    max = Math.max(max, (tep + 1) / 2);
                }
            } else if (seats[i] == 0) {
                tep++;
            } else {
                if (flag1) {
                    flag1 = false;
                    max = Math.max(max, tep + 1);
                } else {
                    max = Math.max(max, (tep + 1) / 2);
                }
                tep = 0;
            }
        }
        return max;
    }

    /**
     * max neighbor
     *
     * @author lf
     * @time 2020-01-13 22:24
     * @param seats seats
     * @return int
     */
    private int maxNeighbor(int[] seats) {
        int i = 0, j = seats.length - 1, max = 0, count = 0;
        while (seats[i] == 0) {
            i++;
            count++;
        }
        max = Math.max(max, count);
        count = 0;
        while (seats[j] == 0) {
            j--;
            count++;
        }
        max = Math.max(max, count);
        count = 0;
        for (; i <= j; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                max = Math.max(max, (count + 1) / 2);
                count = 0;
            }
        }
        return max;
    }
}
