/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_11;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        int profit1 = getMaxProfit(new int[]{7, 1, 5, 3, 6, 10});
        System.out.println(profit1);

        int profit2 = getMaxProfit2(new int[]{7, 1, 5, 3, 6, 10});
        System.out.println(profit2);
    }

    private int getMaxProfit(int[] prices) {
        int result = 0;
        int buy = prices[0];
        boolean isSold = false;
        for (int i = 1; i < prices.length - 1; i++) {
            int curr = prices[i];
            if (!isSold) {
                if (curr < buy) {
                    buy = curr;
                } else if (prices[i + 1] < curr) {
                    result += (curr - buy);
                    isSold = true;
                } else if (i == prices.length - 2) {
                    result += (prices[i + 1] - buy);
                    isSold = true;
                }
            } else {
                buy = curr;
                isSold = false;
            }
        }
        return result;
    }

    private int getMaxProfit2(int[] prices) {
        int result = 0;
        int index = 0;
        while (index < prices.length - 1) {
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int valley = prices[index];
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            int peek = prices[index];
            result += peek - valley;
        }
        return result;
    }
}