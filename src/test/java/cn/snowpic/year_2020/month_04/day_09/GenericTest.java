/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_09;

import cn.snowpic.util.CommonUtils;
import org.junit.Test;

import java.util.Set;

public class GenericTest {

    /**
     * minimum sub str
     *
     * @author Little Flower
     * @date 2020-04-12 23:00:31
     * @param origin origin
     * @param target target
     * @return String
     */
    private String minimumSubStr(String origin, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (!origin.contains(target.charAt(i) + "")) {
                return null;
            }
        }
        int len = Integer.MAX_VALUE;
        int left = -1, right = -1;
        for (int i = 0; i < origin.length(); i++) {
            int stop = -1;
            Set<Character> container = CommonUtils.convert(target);
            for (int j = i; j < origin.length(); j++) {
                container.remove(origin.charAt(j));
                if (container.isEmpty()) {
                    stop = j;
                    break;
                }
            }
            int currLength = stop - i + 1;
            if (stop != -1 && currLength < len) {
                left = i;
                right = stop;
                len = currLength;
            }
        }
        return left < 0 ? null : origin.substring(left, right + 1);
    }

    @Test
    public void test1() {
        String origin = "ADOBECODEBANC";
        String target = "ABC";
        String subStr = minimumSubStr(origin, target);
        System.out.println("subStr = " + subStr);
    }
}
