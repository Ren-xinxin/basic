/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_12;

import org.junit.Test;

public class GenericTest {

    /**
     * duplicate times
     *
     * @author lf
     * @time 2020-02-12 19:08:53
     * @param duplicatedStr duplicated str
     * @param targetSubStr target sub str
     * @return int
     */
    private int duplicateTimes(String duplicatedStr, String targetSubStr) {
        int len = Math.max(duplicatedStr.length() * 2, targetSubStr.length() * 2);
        StringBuilder sb = new StringBuilder();
        for (int times = 1; sb.length() <= len; times++) {
            sb.append(duplicatedStr);
            if (sb.length() > targetSubStr.length() && sb.toString().contains(targetSubStr)) {
                return times;
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        String origin = "abcd";
        String target = "cdabcdab";

        int times = duplicateTimes(origin, target);
        System.out.println("times = " + times);
    }
}
