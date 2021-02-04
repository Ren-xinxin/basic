/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_12.day_11;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/11 0:38
 */
public class GenericTest {

    /**
     * test1 fibonacci O(nlog2n)
     * @author lf
     * @time 2019/12/11 0:42
     */
    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            System.out.print(fibonacci(i) + "\t");
        }
    }

    /**
     * fibonacci
     * @author lf
     * @time 2019/12/11 0:42
     * @param n n
     * @return String
     */
    public String fibonacci(int n) {
        double phi = (Math.sqrt(5) + 1) / 2;
        double v = (Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5);
        DecimalFormat decimalFormat = new DecimalFormat("0");
        return decimalFormat.format(v);
    }

    /**
     * test2
     * @author lf
     * @time 2019/12/11 21:15
     */
    @Test
    public void test2() {
        int[] arrays = {7, 4, 2, 8, 6, 9, 5, 8};
        quickSort(arrays, null);

        System.out.println("arrays = " + Arrays.toString(arrays));
    }

    /**
     * quick sort
     * @author lf
     * @time 2019/12/11 21:51
     * @param arrays arrays
     * @param index index
     */
    public void quickSort(int[] arrays, Integer... index) {
        if (index != null && index.length != 2) {
            throw new IllegalArgumentException("Index must contain the left and the right index.");
        }
        int left = (index == null) ? 0 : index[0];
        int right = (index == null) ? (arrays.length - 1) : index[1];
        if (left < right) {
            int partitionIndex = partition(arrays, left, right);
            quickSort(arrays, left, partitionIndex - 1);
            quickSort(arrays, partitionIndex + 1, right);
        }
    }

    /**
     * partition
     * @author lf
     * @time 2019/12/11 21:51
     * @param arrays arrays
     * @param left left
     * @param right right
     * @return int
     */
    private int partition(int[] arrays, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arrays[i] < arrays[left]) {
                swap(arrays, i, index);
                index++;
            }
        }
        swap(arrays, left, index - 1);
        return index - 1;
    }

    /**
     * swap
     * @author lf
     * @time 2019/12/11 21:51
     * @param arrays arrays
     * @param i i
     * @param index index
     */
    private void swap(int[] arrays, int i, int index) {
        int tem = arrays[i];
        arrays[i] = arrays[index];
        arrays[index] = tem;
    }
}
