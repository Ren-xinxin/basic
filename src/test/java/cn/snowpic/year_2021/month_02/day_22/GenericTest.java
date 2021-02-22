package cn.snowpic.year_2021.month_02.day_22;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(checkMonotone(new int[]{1, 2, 2, 3}));
        System.out.println(checkMonotone(new int[]{6, 5, 4, 4}));
        System.out.println(checkMonotone(new int[]{1, 3, 2}));
        System.out.println("===============================");
        System.out.println(checkMonotone2(new int[]{1, 2, 2, 3}));
        System.out.println(checkMonotone2(new int[]{6, 5, 4, 4}));
        System.out.println(checkMonotone2(new int[]{1, 3, 2}));
    }

    private boolean checkMonotone(int[] array) {
        int[] clone = array.clone();
        Arrays.sort(clone);
        int index = 0;
        boolean flag = true;
        for (int i : array) {
            if (i != clone[index++]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        index = array.length - 1;
        for (int i : array) {
            if (i != clone[index--]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkMonotone2(int[] array) {
        return checkMonotone(array, true);
    }

    private boolean checkMonotone(int[] array, boolean flag) {
        for (int i = 0; i < array.length - 1; i++) {
            if (flag) {
                // decreasing
                if (array[i] < array[i + 1]) {
                    return checkMonotone(array, false);
                }
            } else {
                // increasing
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
