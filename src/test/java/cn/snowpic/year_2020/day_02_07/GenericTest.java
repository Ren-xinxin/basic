/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_07;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GenericTest {

    /**
     * construct
     *
     * @author lf
     * @time 2020-02-07 19:41:14
     * @param ransom ransom
     * @param magazine magazine
     * @return boolean
     */
    private boolean construct(String ransom, String magazine) {
        List<Integer> chars = new StringBuilder(magazine)
                .chars()
                .boxed()
                .collect(Collectors.toList());
        char[] ransoms = ransom.toCharArray();
        for (char r : ransoms) {
            if (!chars.remove(Integer.valueOf(r))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        boolean construct1 = construct("aa", "ab");
        System.out.println("construct1 = " + construct1);

        boolean construct2 = construct("baa", "aba");
        System.out.println("construct1 = " + construct2);
    }
}
