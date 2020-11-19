/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_19;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(findDuplicates(new int[]{1, 2, 3, 1}));
        System.out.println(findDuplicates(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i + 1; j++) {
                String msg = String.format("%d * %d = %d", i + 1, j + 1, (i + 1) * (j + 1));
                System.out.print(msg + "\t");
            }
            System.out.println();
        }
    }

    private boolean findDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }
}
