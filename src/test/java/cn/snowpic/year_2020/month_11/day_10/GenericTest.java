/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_10;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int[] price1 = {7, 1, 5, 3, 6, 4};
        int profit1 = calcMaxProfit(price1);
        System.out.println("profit1 = " + profit1);

        System.out.println(calcMaxProfit1(price1));
    }

    private int calcMaxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    private int calcMaxProfit1(int[] prices) {
        int max = Integer.MIN_VALUE;

        int bought = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            if (curr < bought) {
                bought = curr;
            } else {
                max = Math.max(max, curr - bought);
            }
        }

        return max;
    }
}