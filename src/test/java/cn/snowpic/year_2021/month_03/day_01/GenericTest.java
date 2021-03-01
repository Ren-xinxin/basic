package cn.snowpic.year_2021.month_03.day_01;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(Arrays.toString(calcNextPermutation(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(calcNextPermutation(new int[]{1, 2, 4, 3})));
        System.out.println(Arrays.toString(calcNextPermutation(new int[]{4, 3, 2, 1})));
    }

    private int[] calcNextPermutation(int[] array) {
        int index = array.length - 1;
        while (index > 0 && array[index] < array[index - 1]) {
            index--;
        }
        if (index > 0) {
            swap(array, index, index - 1);
            reverse(array, index + 1);
            return array;
        }
        reverse(array, 0);
        return array;
    }

    private void reverse(int[] array, int left) {
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
