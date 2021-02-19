package cn.snowpic.year_2021.month_02.day_19;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(countMaxClosestSeats(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(countMaxClosestSeats(new int[]{1, 0, 0, 0}));
    }

    private int countMaxClosestSeats(int[] seats) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        boolean flag = true;
        for (int seat : seats) {
            if (seat == 0) {
                count++;
            } else {
                max = Math.max(max, flag ? count * 2 : count);
                flag = false;
                count = 0;
            }
        }
        max = Math.max(max, count * 2);
        return (max + 1) / 2;
    }

    @Test
    public void test2() {
        System.out.println(checkFullPackage(new int[]{1, 2, 3}, 6));
        System.out.println(checkFullPackage(new int[]{1, 2, 3}, 7));
    }

    private boolean checkFullPackage(int[] weights, int total) {
        boolean[] flags = new boolean[total + 1];
        flags[0] = true;
        for (int weight : weights) {
            for (int i = total; i >= weight; i--) {
                flags[i] = flags[i - weight] || flags[i];
            }
            if (flags[total]) {
                return true;
            }
        }
        return false;
    }
}
