/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_08;

import org.junit.Test;

public class GenericTest {

    /**
     * compress
     *
     * @author lf
     * @time 2020-02-08 18:56:23
     * @param inputs inputs
     * @return String
     */
    private String compress(char[] inputs) {
        char prev = inputs[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] == prev) {
                count++;
            } else {
                sb.append(prev);
                if (count > 1) {
                    sb.append(count);
                }
                prev = inputs[i];
                count = 1;
            }
        }
        sb.append(prev);
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        char[] inputs = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        String compressed = compress(inputs);
        System.out.println("compressed = " + compressed);
    }
}
