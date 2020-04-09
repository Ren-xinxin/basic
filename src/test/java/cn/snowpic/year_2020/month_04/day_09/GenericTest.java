/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_09;

public class GenericTest {

    private String minimumSubStr(String origin, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (!origin.contains(target.charAt(i) + "")) {
                return "";
            }
        }
        for (int i = 0; i < origin.length(); i++) {

        }
        return "";
    }
}
