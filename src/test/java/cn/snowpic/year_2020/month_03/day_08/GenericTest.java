/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_08;

import org.apache.curator.shaded.com.google.common.util.concurrent.AtomicDouble;
import org.junit.Test;

import java.text.DecimalFormat;

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
     * @return String
     */
    private String blackJack(final int originLimit, final int stopLimit, final int targetLimit) {
        if (stopLimit < 0 || originLimit < 0 || targetLimit < 0)
            throw new IllegalArgumentException("Params is illegal.");
        AtomicDouble targetCount = new AtomicDouble();
        AtomicDouble allCount = new AtomicDouble();
        play(originLimit, stopLimit, targetLimit, 0, targetCount, allCount, 1.0);
        double result = targetCount.get() / allCount.get();
        DecimalFormat sf = new DecimalFormat("0.00000");
        return sf.format(result);
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
    private void play(final int originLimit, final int stopLimit, final int targetLimit, int currentTotal, AtomicDouble targetCount, AtomicDouble allCount, double weight) {
        if (currentTotal > 0) {
            if (currentTotal >= stopLimit) {
                if (currentTotal <= targetLimit) {
                    targetCount.getAndAdd(weight);
                }
                allCount.getAndAdd(weight);
                return;
            }
        }
        for (int i = 1; i <= originLimit; i++) {
            play(originLimit, stopLimit, targetLimit, currentTotal + i, targetCount, allCount, weight / originLimit);
        }
    }

    @Test
    public void test1() {
        String jack = blackJack(10, 1, 10);
        System.out.println("jack = " + jack);

        String jack1 = blackJack(10, 1, 6);
        System.out.println("jack1 = " + jack1);

        String jack2 = blackJack(10, 17, 21);
        System.out.println("jack2 = " + jack2);
    }
}