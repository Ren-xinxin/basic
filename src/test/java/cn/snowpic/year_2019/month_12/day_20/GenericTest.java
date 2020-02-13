/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.month_12.day_20;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/20 18:56
 */
public class GenericTest {

    @Test
    public void test1() {
        System.out.println("majority = " + majority(new int[]{4, 1, 2, 3, 4}));
    }

    /**
     * majority
     * @author lf
     * @time 2019/12/20 18:58
     * @param arrays arrays
     * @return int
     */
    private int majority(int[] arrays) {
        int count = 1;
        int majority = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (count == 0 || arrays[i] == majority) {
                count++;
                majority = arrays[i];
            } else {
                count--;
            }
        }
        return majority;
    }

    /**
     * majority2
     * @author lf
     * @time 2019/12/20 19:37
     * @param arrays arrays
     * @return int
     */
    private int majority2(int[] arrays) {
        int j = arrays.length - 1;
        for (int i = 0; i < arrays.length - 1; i++) {
            if (arrays[i] != arrays[j]) {
                j--;
            }
        }
        return 0;
    }

    @Test
    public void test2() {
        int[] arrays = {1, 2, 1};
        Majority majority = majority(arrays, 0, arrays.length - 1);
        System.out.println("majority = " + majority);
    }

    /**
     * majority with partition solution
     * todo It is wrong but I won't fix it.
     * @author lf
     * @time 2019/12/21 0:06
     * @param arrays arrays
     * @return int
     */
    private Majority majority(int[] arrays, int i, int j) {
        if (j == i) {
            return new Majority(arrays[i], 1);
        } else {
            Majority majority1 = majority(arrays, i, j / 2);
            Majority majority2 = majority(arrays, j / 2 + 1, j);
            if (majority1.maj == majority2.maj) {
                return new Majority(majority1.maj, majority1.count + majority1.count);
            } else if (majority1.count == majority2.count) {
                return new Majority(-1, -1);
            } else if (majority1.count > majority2.count) {
                return new Majority(majority1.maj, majority1.count);
            } else {
                return new Majority(majority2.maj, majority2.count);
            }
        }
    }

    private static class Majority {

        private int maj;

        private int count;

        public Majority(int maj, int count) {
            this.maj = maj;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"maj\":" + maj +
                    ",\"count\":" + count +
                    "}";
        }
    }

    @Test
    public void test3() {
        int[] arrays = new int[]{1, 2, 0, 8, 9, 5, 0, 4};
        moveZero(arrays);
        System.out.println("arrays = " + Arrays.toString(arrays));
    }

    /**
     * move zero
     * @author lf
     * @time 2019/12/21 0:33
     * @param arrays arrays
     */
    private void moveZero(int[] arrays) {
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != 0) {
                arrays[index++] = arrays[i];
            }
        }

        for (int i = index; i < arrays.length; i++) {
            arrays[i] = 0;
        }
    }
}
