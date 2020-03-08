/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_08;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * generic test
 *
 * @className GenericTest
 * @author Little Flower
 * @date 2020-03-08 14:12:09
 */
public class GenericTest {

    /**
     * black jack
     *
     * @author Little Flower
     * @date 2020-03-08 15:58:07
     * @param originLimit origin limit
     * @param stopLimit stop limit
     * @param targetLimit target limit
     * @return double
     */
    private double blackJack(final int originLimit, final int stopLimit, final int targetLimit) {
        if (stopLimit < 0 || originLimit < 0 || targetLimit < 0)
            throw new IllegalArgumentException("Params is illegal.");
        AtomicInteger targetCount = new AtomicInteger();
        AtomicInteger allCount = new AtomicInteger();
        play(originLimit, stopLimit, targetLimit, 0, targetCount, allCount);
        return targetCount.get() * 1.0 / allCount.get();
    }

    /**
     * play
     *
     * @author Little Flower
     * @date 2020-03-08 15:56:13
     * @param originLimit origin limit
     * @param stopLimit stop limit
     * @param targetLimit target limit
     * @param currentTotal current total
     * @param targetCount target count
     * @param allCount all count
     */
    private void play(final int originLimit, final int stopLimit, final int targetLimit, int currentTotal, AtomicInteger targetCount, AtomicInteger allCount) {
        if (currentTotal > 0) {
            if (currentTotal >= stopLimit) {
                if (currentTotal <= targetLimit) {
                    targetCount.getAndIncrement();
                }
                allCount.getAndIncrement();
                return;
            }
        }
        for (int i = 1; i <= originLimit; i++) {
            play(originLimit, stopLimit, targetLimit, currentTotal + i, targetCount, allCount);
        }
    }

    @Test
    public void test1() {
        double jack = blackJack(10, 1, 10);
        System.out.println("jack = " + jack);

        double jack1 = blackJack(10, 1, 6);
        System.out.println("jack1 = " + jack1);

        double jack2 = blackJack(3, 4, 4);
        System.out.println("jack2 = " + jack2);
    }
}