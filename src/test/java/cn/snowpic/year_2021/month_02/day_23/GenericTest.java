package cn.snowpic.year_2021.month_02.day_23;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(Arrays.toString(sortByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortByParity(new int[]{4, 5, 1, 3})));
        System.out.println("====================");
        System.out.println(Arrays.toString(sortByParity2(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortByParity2(new int[]{4, 5, 1, 3})));
    }

    private int[] sortByParity(int[] array) {
        int left = 0, right = array.length - 1;
        outer:
        while (left < right) {
            while (array[left] % 2 == 0) {
                if (++left >= right) {
                    break outer;
                }
            }
            while (array[right] % 2 != 0) {
                if (--right <= left) {
                    break outer;
                }
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        return array;
    }

    private int[] sortByParity2(int[] array) {
        int[] result = new int[array.length];
        int left = 0, right = array.length - 1;
        for (int num : array) {
            if (num % 2 == 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }
        return result;
    }
}
