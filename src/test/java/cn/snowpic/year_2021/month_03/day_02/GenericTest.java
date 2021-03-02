package cn.snowpic.year_2021.month_03.day_02;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(searchRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    private int searchRotatedArray(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
