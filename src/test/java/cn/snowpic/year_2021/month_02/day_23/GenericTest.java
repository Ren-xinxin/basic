package cn.snowpic.year_2021.month_02.day_23;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(Arrays.toString(sortByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortByParity(new int[]{4, 5, 1, 3})));
    }

    private int[] sortByParity(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (array[left] % 2 == 0 && left < array.length - 1) {
                left++;
            }
            while (array[right] % 2 != 0 && right > 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return array;
    }
}
