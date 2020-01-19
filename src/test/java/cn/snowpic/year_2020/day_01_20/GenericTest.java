/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_20;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-20 0:31
     */
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        List<String> vampire = vampire();
        System.out.println("vampire = " + vampire);
        System.out.println("cost " + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * vampire
     *
     * @author lf
     * @time 2020-01-20 0:43
     * @return @List<String>
     */
    private List<String> vampire() {
        List<String> result = new ArrayList<>();

        solution:
        for (int number = 1000; number < 10000; number++) {
            int tep = number;
            int[] array = new int[4];
            int index = 0;
            do {
                array[index++] = tep % 10;
                tep /= 10;
            } while (tep > 0);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == i) continue;
                    for (int k = 0; k < 4; k++) {
                        if (k == i || k == j) continue;
                        for (int m = 0; m < 4; m++) {
                            if (m == i || m == j || m == k) continue;
                            int a = array[i];
                            int b = array[j];
                            int c = array[k];
                            int d = array[m];
                            if (a == 0 || c == 0 || (b == 0 && d == 0)) continue;
                            int o = a * 10 + b;
                            int p = c * 10 + d;
                            if (number == o * p) {
                                String format = String.format("%s = %s * %s", number, o, p);
                                result.add(format);
                                continue solution;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
