/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_11;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int profit1 = getMaxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit1);
    }

    private int getMaxProfit(int[] prices) {
        int result = 0;
        int buy = prices[0];
        boolean isSold = false;
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            if (!isSold) {
                if (curr < buy) {
                    buy = curr;
                } else {
                    result += (curr - buy);
                    isSold = true;
                }
            } else {
                buy = curr;
                isSold = false;
            }
        }
        return result;
    }
}