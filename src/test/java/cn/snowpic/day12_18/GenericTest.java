/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day12_18;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/18 23:21
 */
public class GenericTest {

    /**
     * rotate algorithm
     * @author lf
     * @time 2019/12/18 23:24
     */
    @Test
    public void test1() {
        int[] rotate = rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println("rotate = " + Arrays.toString(rotate));
    }

    /**
     * rotate
     * @author lf
     * @time 2019/12/18 23:24
     * @param arrays arrays
     * @param offset offset
     * @return int[]
     */
    private int[] rotate(int[] arrays, int offset) {
        int[] result = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            result[(i + offset) % arrays.length] = arrays[i];
        }
        return result;
    }

    /**
     * find if a arrays has duplicated elements
     * @author lf
     * @time 2019/12/18 23:29
     */
    @Test
    public void test2() {
        boolean duplicated = findDuplicated(new int[]{1, 2, 3});
        System.out.println("duplicated = " + duplicated);
    }

    /**
     * find duplicated
     * @author lf
     * @time 2019/12/18 23:33
     * @param arrays arrays
     * @return boolean
     */
    private boolean findDuplicated(int[] arrays) {
        Set<Integer> workSet = new HashSet<>();
        for (int i = 0; i < arrays.length; i++) {
            if (!workSet.add(arrays[i])) {
                return false;
            }
        }
        return true;
    }
}
