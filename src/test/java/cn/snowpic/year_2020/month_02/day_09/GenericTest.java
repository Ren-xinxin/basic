/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_09;

import org.junit.Test;

public class GenericTest {

    /**
     * reverse half count
     *
     * @author lf
     * @time 2020-02-09 18:54:20
     * @param input input
     * @param target target
     * @return String
     */
    private String reverseHalfCount(String input, int target) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); i += 2 * target) {
            int left = i;
            int right = i + target - 1;
            // ensure index will not out of bound
            right = right < input.length() ? right : input.length() - 1;
            while (left < right) {
                char tep = chars[left];
                chars[left] = chars[right];
                chars[right] = tep;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    @Test
    public void test1() {
        String str = "abcdefg";

        String reversed = reverseHalfCount(str, 2);
        System.out.println("reversed = " + reversed);
    }

    /**
     * can be reword
     *
     * @author lf
     * @time 2020-02-09 19:36:12
     * @param present present
     * @return boolean
     */
    private boolean canBeReworded(String present) {
        boolean haveAbsent = false;
        int continuousLateCount = 0;
        for (int i = 0; i < present.length(); i++) {
            char current = present.charAt(i);
            switch (current) {
                case 'A': {
                    if (haveAbsent) {
                        return false;
                    }
                    haveAbsent = true;
                    break;
                }
                case 'L': {
                    continuousLateCount++;
                    if (continuousLateCount >= 3) {
                        return false;
                    }
                    break;
                }
                default: {
                    continuousLateCount = 0;
                }
            }
        }
        return true;
    }

    @Test
    public void test2() {
        String present = "PPALLP";
        boolean reworded = canBeReworded(present);
        System.out.println("reworded = " + reworded);

        String present1 = "PPALLL";
        boolean reworded1 = canBeReworded(present1);
        System.out.println("reworded1 = " + reworded1);
    }
}
