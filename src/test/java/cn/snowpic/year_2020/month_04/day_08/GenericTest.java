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
        StepInfo info = new StepInfo(origin, target);
        info.count = multiplexElements(origin, target, 0, 0, 0, new AtomicBoolean(true), info);
        return info.steps();
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
        private int ol;
        private int or;
        private int tl;
        private int tr;

        private final String origin;
        private final String target;

        private int count = -1;

        public StepInfo(String origin, String target) {
            this.origin = origin;
            this.target = target;
        }

        private int left() {
            return Math.max(ol, tl);
        }

        private int middle() {
            if (count == -1) {
                throw new RuntimeException("Count must be initialize");
            }
            int tc = (tr - tl + 1) - count;
            int oc = (or - ol + 1) - count;
            return Math.max(tc, oc);
        }

        private int right() {
            int orc = origin.length() - 1 - or;
            int trc = target.length() - 1 - tr;
            return Math.max(orc, trc);
        }

        private int steps() {
            return left() + middle() + right();
        }
    }

    @Test
    public void test1() {
        int steps = minSteps("ac", "abc");
        System.out.println("steps = " + steps);
        int steps1 = minSteps("aac", "abc");
        System.out.println("steps1 = " + steps1);
        int steps2 = minSteps("horse", "ros");
        System.out.println("steps2 = " + steps2);
    }
}
