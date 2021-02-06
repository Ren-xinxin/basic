/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_06;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(Arrays.deepToString(smoothPicture(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));
        System.out.println(Arrays.deepToString(smoothPicture(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}})));
    }

    private int[][] smoothPicture(int[][] origin) {
        int xLen = origin.length;
        int yLen = origin[0].length;
        int[][] result = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                int divisor = 0;
                int sum = 0;
                int xStart = (i == 0) ? 0 : i - 1;
                int xEnd = (i == xLen - 1) ? xLen - 1 : i + 1;
                int yStart = (j == 0) ? 0 : j - 1;
                int yEnd = (j == yLen - 1) ? yLen - 1 : j + 1;
                for (int k = xStart; k <= xEnd; k++) {
                    for (int z = yStart; z <= yEnd; z++) {
                        divisor++;
                        sum += origin[k][z];
                    }
                }
                result[i][j] = Math.floorDiv(sum, divisor);
            }
        }
        return result;
    }
}
