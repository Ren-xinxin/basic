package cn.snowpic.year_2021.month_02.day_20;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(Arrays.deepToString(rotateMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(rotateMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }

    private int[][] rotateMatrix(int[][] origin) {
        int[][] result = new int[origin[0].length][origin.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = origin[j][i];
            }
        }
        return result;
    }
}
