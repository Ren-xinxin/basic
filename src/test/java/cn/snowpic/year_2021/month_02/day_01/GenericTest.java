/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_01;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(Arrays.deepToString(reshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(reshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
    }

    private int[][] reshape(int[][] nums, int r, int c) {
        int originColumn = nums[0].length;
        if (nums.length * originColumn != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[index / originColumn][index % originColumn];
                index++;
            }
        }
        return result;
    }

    @Test
    public void test2() {
        System.out.println(getFactorial(10));
        System.out.println(getFactorial(2));
        System.out.println(getFactorial(1000));
    }

    private String getFactorial(int n) {
        return factorial(n).toString();
    }

    private BigDecimal factorial(int n) {
        if (n == 0 || n == 1) {
            return new BigDecimal(1);
        }
        return new BigDecimal(n).multiply(factorial(n - 1));
    }
}
