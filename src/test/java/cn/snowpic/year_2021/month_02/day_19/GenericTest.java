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
}
