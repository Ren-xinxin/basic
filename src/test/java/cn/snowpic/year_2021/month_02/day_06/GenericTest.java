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
        System.out.println(Arrays.deepToString(smoothPicture2(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));
        System.out.println(Arrays.deepToString(smoothPicture2(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}})));
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

    private int[][] smoothPicture2(int[][] origin) {
        int[][] result = origin.clone();
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[0].length; j++) {
                bfs(origin, result, i, j);
            }
        }
        return result;
    }

    private void bfs(int[][] origin, int[][] result, int i, int j) {
        int xLen = origin.length;
        int yLen = origin[0].length;
        int divisor = 1;
        int sum = origin[i][j];
        // left up
        if (i - 1 >= 0 && j - 1 >= 0) {
            sum += origin[i - 1][j - 1];
            divisor++;
        }
        // up
        if (j - 1 >= 0) {
            sum += origin[i][j - 1];
            divisor++;
        }
        // right up
        if (i + 1 <= xLen - 1 && j - 1 >= 0) {
            sum += origin[i + 1][j - 1];
            divisor++;
        }
        // left
        if (i - 1 >= 0) {
            sum += origin[i - 1][j];
            divisor++;
        }
        // right
        if (i + 1 <= xLen - 1) {
            sum += origin[i + 1][j];
            divisor++;
        }
        // left down
        if (i - 1 >= 0 && j + 1 <= yLen - 1) {
            sum += origin[i - 1][j + 1];
            divisor++;
        }
        // down
        if (j + 1 <= yLen - 1) {
            sum += origin[i][j + 1];
            divisor++;
        }
        // right down
        if (i + 1 < xLen - 1 && j + 1 <= yLen - 1) {
            sum += origin[i + 1][j + 1];
            divisor++;
        }
        result[i][j] = Math.floorDiv(sum, divisor);
    }
}
