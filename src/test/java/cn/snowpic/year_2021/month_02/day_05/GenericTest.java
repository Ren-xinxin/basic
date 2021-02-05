/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_05;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        prime(10);
        prime(100);
        prime(1000);
        prime(10000);
        prime(100000);
        prime(1000000);
    }

    private void prime(int len) {
        boolean[] flag = new boolean[len + 1];
        for (int i = 2; i <= Math.sqrt(len); i++) {
            for (int j = i; i * j <= len; j++) {
                flag[i * j] = true;
            }
        }
        for (int i = 2; i < len; i++) {
            if (!flag[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
