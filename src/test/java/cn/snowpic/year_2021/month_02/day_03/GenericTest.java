/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_03;

import org.junit.Test;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(plantFlower(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(plantFlower(new int[]{1, 0, 0, 0, 1}, 2));
    }

    public boolean plantFlower(int[] flowered, int num) {
        int count = 0;
        for (int i = 1; i < flowered.length - 1; i++) {
            if (flowered[i - 1] == 0 && flowered[i] == 0 && flowered[i + 1] == 0) {
                flowered[i] = 1;
                if (++count == num) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test2() {
        System.out.println(getGcd(12, 8));
    }

    private int getGcd(int num1, int num2) {
        if (num2 > num1) {
            return getGcd(num2, num1);
        }
        int mod = num1 % num2;
        if (mod == 0) {
            return num2;
        }
        return getGcd(num2, mod);
    }
}
