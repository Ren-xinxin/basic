/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_12_11;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/11 0:38
 */
public class GenericTest {

    /**
     * test1 fibonacci O(nlog2n)
     * @author lf
     * @time 2019/12/11 0:42
     */
    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            System.out.print(fibonacci(i) + "\t");
        }
    }

    /**
     * fibonacci
     * @author lf
     * @time 2019/12/11 0:42
     * @param n n
     * @return String
     */
    public String fibonacci(int n) {
        double phi = (Math.sqrt(5) + 1) / 2;
        double v = (Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5);
        DecimalFormat decimalFormat = new DecimalFormat("0");
        return decimalFormat.format(v);
    }
}
