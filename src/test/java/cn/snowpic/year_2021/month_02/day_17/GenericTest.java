package cn.snowpic.year_2021.month_02.day_17;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findLargestTwice(new int[]{3, 6, 1, 0}));
        System.out.println(findLargestTwice(new int[]{1, 2, 3, 4}));
    }

    private int findLargestTwice(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        int finalMax = max;
        return Arrays.stream(array)
                .anyMatch(num -> num != 0 && num != finalMax && finalMax / num < 2) ? -1 : index;
    }
}
