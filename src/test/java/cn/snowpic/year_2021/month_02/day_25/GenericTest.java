package cn.snowpic.year_2021.month_02.day_25;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findMaxVolContainer(new int[]{1, 2, 5, 7, 8, 10, 12, 2, 34}));
    }

    private int findMaxVolContainer(int[] array) {
        int result = Integer.MIN_VALUE;
        for (int window = 1; window < array.length; window++) {
            for (int i = 0; i + window < array.length; i++) {
                int num = Math.min(array[i], array[i + window]);
                result = Math.max(result, num * window);
            }
        }
        return result;
    }
}
