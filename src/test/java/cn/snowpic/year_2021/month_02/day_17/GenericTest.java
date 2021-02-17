package cn.snowpic.year_2021.month_02.day_17;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findLargestTwice(new int[]{3, 6, 1, 0}));
        System.out.println(findLargestTwice(new int[]{1, 2, 3, 4}));
    }

    private int findLargestTwice(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        int finalMax = max;
        return Arrays.stream(array)
                .anyMatch(num -> num != 0 && num != finalMax && finalMax / num < 2) ? -1 : index;
    }

    @Test
    public void test2() {
        System.out.println(checkToeplitz(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println(checkToeplitz(new int[][]{{1, 2}, {2, 2}}));
    }

    private boolean checkToeplitz(int[][] matrix) {
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int y = yLen - 1;
        int x = 0;
        while (x < xLen) {
            int curr = matrix[x][y];
            int tempX = x;
            int tempY = y;
            while (++tempX < xLen && ++tempY < yLen) {
                if (matrix[tempX][tempY] != curr) {
                    return false;
                }
            }
            if (y > 0) {
                y--;
            } else {
                x++;
            }
        }
        return true;
    }
}
