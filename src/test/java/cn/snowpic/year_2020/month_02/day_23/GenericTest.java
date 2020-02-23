/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_23;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-23 16:44:40
 */
public class GenericTest {

    private String reverse(String input) {
        String[] split = input.trim().split("\\s+");
        int left = 0, right = split.length - 1;
        while (left < right) {
            // swap
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", split);
    }

    @Test
    public void test1() {
        String input = "the sky is blue";
        String reversed = reverse(input);
        System.out.println("reversed = " + reversed);
    }

    /**
     * compare version
     *
     * @author lf
     * @time 2020-02-23 17:17:34
     * @param version1 version1
     * @param version2 version2
     * @return int
     */
    private int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.min(split1.length, split2.length);
        int flag = 0;
        for (int i = 0; i < len; i++) {
            int v1 = Integer.parseInt(split1[i]);
            int v2 = Integer.parseInt(split2[i]);
            if (v1 > v2) {
                flag = 1;
                break;
            }
            if (v1 < v2) {
                flag = -1;
                break;
            }
        }
        return (split1.length == split2.length) ? flag :
                (flag == 0 ? (split1.length > split2.length ? 1 : -1) : flag);
    }

    @Test
    public void test2() {
        int compareVersion = compareVersion("1.1.0.23", "1.1.0");
        System.out.println("compareVersion = " + compareVersion);
    }
}
