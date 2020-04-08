/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_08;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class GenericTest {

    /**
     * min steps
     *
     * @author Little Flower
     * @date 2020-04-09 00:19:56
     * @param origin origin
     * @param target target
     * @return int
     */
    private int minSteps(String origin, final String target) {
        int max = Integer.MIN_VALUE;
        StepInfo result = null;
        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < origin.length(); j++) {
                StepInfo info = new StepInfo();
                int steps = multiplexElements(origin, target, j, i, 0, new AtomicBoolean(true), info);
                if (steps > max) {
                    max = steps;
                    result = info;
                }
            }
        }
        if (result == null) throw new RuntimeException("sb");
        int left = Math.max(result.ol, result.tl);
        int middle = Math.abs((result.or - result.ol + 1) - (result.tr - result.tl + 1));
        int right = Math.max(origin.length() - 1 - result.or, target.length() - 1 - result.tr);
        return left + middle + right;
    }

    /**
     * multiplex elements
     *
     * @author Little Flower
     * @date 2020-04-09 00:14:20
     * @param origin origin
     * @param target target
     * @param oi oi
     * @param ti ti
     * @param currUsed curr used
     * @param isLeft is left
     * @param stepInfo step info
     * @return int
     */
    private int multiplexElements(final String origin, final String target, int oi, int ti, int currUsed, AtomicBoolean isLeft, StepInfo stepInfo) {
        if (oi == origin.length() || ti == target.length()) {
            return currUsed;
        }
        if (origin.charAt(oi) == target.charAt(ti)) {
            if (isLeft.get()) {
                isLeft.set(false);
                stepInfo.ol = oi;
                stepInfo.tl = ti;
            }
            stepInfo.or = oi;
            stepInfo.tr = ti;
            return multiplexElements(origin, target, oi + 1, ti + 1, currUsed + 1, isLeft, stepInfo);
        } else {
            int e1 = multiplexElements(origin, target, oi + 1, ti, currUsed, isLeft, stepInfo);
            int e2 = multiplexElements(origin, target, oi, ti + 1, currUsed, isLeft, stepInfo);
            return Math.max(e1, e2);
        }
    }

    /**
     * step info
     *
     * @className StepInfo
     * @author Little Flower
     * @date 2020-04-09 00:20:06
     */
    private static class StepInfo {
        int ol;
        int or;
        int tl;
        int tr;
    }

    @Test
    public void test1() {
        int steps = minSteps("ac", "abc");
        System.out.println("steps = " + steps);
    }
}
