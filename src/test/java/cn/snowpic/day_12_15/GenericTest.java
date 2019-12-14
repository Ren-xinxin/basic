/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_12_15;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/15 0:09
 */
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/12/15 0:15
     */
    @Test
    public void test1() {
        int[] merge = merge(new int[]{2, 3, 4, 7, 7, 9}, new int[]{1, 1, 2, 3, 4, 5, 6, 6, 7, 7, 7});
        System.out.println("merge = " + Arrays.toString(merge));
    }

    /**
     * merge
     * @author lf
     * @time 2019/12/15 0:15
     * @param arrays1 arrays1
     * @param arrays2 arrays2
     * @return int[]
     */
    private int[] merge(int[] arrays1, int[] arrays2) {
        int[] result = new int[arrays1.length + arrays2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < result.length) {
            if (i == arrays1.length) {
                result[k++] = arrays2[j++];
                continue;
            }
            if (j == arrays2.length) {
                result[k++] = arrays1[i++];
                continue;
            }
            if (arrays1[i] < arrays2[j]) {
                result[k++] = arrays1[i++];
            } else {
                result[k++] = arrays2[j++];
            }
        }
        System.out.println(i + " " + j + " " + k);
        return result;
    }
}
