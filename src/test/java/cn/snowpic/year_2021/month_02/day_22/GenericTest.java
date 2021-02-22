package cn.snowpic.year_2021.month_02.day_22;

import org.junit.Test;

import java.util.Arrays;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(checkMonotone(new int[]{1, 2, 2, 3}));
        System.out.println(checkMonotone(new int[]{6, 5, 4, 4}));
        System.out.println(checkMonotone(new int[]{1, 3, 2}));
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
}
