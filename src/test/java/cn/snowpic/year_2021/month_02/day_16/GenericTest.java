package cn.snowpic.year_2021.month_02.day_16;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(checkLastOneBit(new int[]{1, 0, 0}));
        System.out.println(checkLastOneBit(new int[]{1, 1, 1, 0}));
        System.out.println(checkLastOneBit2(new int[]{1, 0, 0}));
        System.out.println(checkLastOneBit2(new int[]{1, 1, 1, 0}));
    }

    private boolean checkLastOneBit(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                i++;
            } else if (i == array.length - 1) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLastOneBit2(int[] array) {
        int index = 0;
        int lastIndex = array.length - 1;
        while (index < lastIndex) {
            if (array[index] == 1) {
                index += 2;
            } else {
                index++;
            }
        }
        return index == lastIndex;
    }
}
