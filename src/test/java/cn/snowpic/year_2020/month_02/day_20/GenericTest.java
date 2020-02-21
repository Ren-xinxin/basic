/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_20;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-20 23:13:01
 */
public class GenericTest {

    /**
     * decrypt
     *
     * @author lf
     * @time 2020-02-20 23:12:54
     * @param input input
     * @return @List<String>
     */
    private List<String> decrypt(String input) {
        int[] numbers = new int[input.length()];
        for (int i = 0; i < input.toCharArray().length; i++) {
            numbers[i] = Integer.parseInt(input.charAt(i) + "");
        }
        List<String> result = new ArrayList<>();
        decrypt(numbers, 0, 1, "", result);
        decrypt(numbers, 0, 2, "", result);
        return result;
    }

    /**
     * decrypt
     *
     * @author lf
     * @time 2020-02-20 23:13:11
     * @param array array
     * @param index index
     * @param step step
     * @param str str
     * @param result result
     */
    private void decrypt(int[] array, int index, int step, String str, List<String> result) {
        int addedIndex = index + step;
        if (addedIndex > array.length) {
            return;
        }
        int tep = step == 1 ? array[index] : Integer.parseInt(array[index] + "" + array[index + 1]);
        if (tep > 26) {
            return;
        }
        str += (char) (tep + 'A' - 1);
        // whether current index is the last
        if (addedIndex == array.length) {
            result.add(str);
            return;
        }
        decrypt(array, addedIndex, 1, str, result);
        decrypt(array, addedIndex, 2, str, result);
    }

    @Test
    public void test1() {
        List<String> decrypted = decrypt("12");
        System.out.println(decrypted);

        System.out.println(decrypt("226"));
    }
}
