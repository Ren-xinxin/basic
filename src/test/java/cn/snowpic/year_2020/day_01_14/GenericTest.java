/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_01_14;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2020-01-14 22:24
     */
    @Test
    public void test1() {
        int[] tom = {1, 1};
        int[] cat = {2, 2};
        int[] exchangeCandy = exchangeCandy(tom, cat);
        System.out.println("exchangeCandy = " + Arrays.toString(exchangeCandy));
    }

    /**
     * exchange candy
     *
     * @author lf
     * @time 2020-01-14 22:33
     * @param tom tom
     * @param bob bob
     * @return int[]
     */
    private int[] exchangeCandy(int[] tom, int[] bob) {
        int tomSum = Arrays.stream(tom).sum();
        int bobSum = Arrays.stream(bob).sum();
        int delta = (bobSum - tomSum) / 2;
        Set<Integer> tomSet = new HashSet<>();
        Set<Integer> bobSet = new HashSet<>();
        for (int t : tom) tomSet.add(t);
        for (int b : bob) bobSet.add(b);

        for (Integer ts : tomSet) {
            int tep = ts + delta;
            if (bobSet.contains(tep)) {
                return new int[]{ts, ts + delta};
            }
        }
        throw new RuntimeException();
    }
}
