/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_09;

import org.junit.Test;

public class GenericTest1 {
    private int count;

    @Test
    public void test1() {
        int[][] island = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        int count = getMaxCount(island);
        System.out.println(count);
        System.out.println(getMaxCount(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
    }

    private int getMaxCount(int[][] island) {
        int result = Integer.MIN_VALUE;
        boolean[][] flag = new boolean[island.length][island[0].length];
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (!flag[i][j]) {
                    count = 0;
                    dfs(island, i, j, flag);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] island, int i, int j, boolean[][] flag) {
        if (i < 0 || j < 0 || i > island.length - 1 || j > island[0].length - 1 || flag[i][j] || island[i][j] == 0) {
            return;
        }
        count++;
        flag[i][j] = true;
        dfs(island, i + 1, j, flag);
        dfs(island, i - 1, j, flag);
        dfs(island, i, j + 1, flag);
        dfs(island, i, j - 1, flag);
    }
}
