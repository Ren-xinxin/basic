/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_12.day_03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(compress("aaabbbaacc"));
        System.out.println(compress("abc"));
    }

    /**
     * compress
     *
     * @author Little Flower
     * @date 2020-12-04 23:57:54
     * @param input input
     * @return String
     */
    private String compress(String input) {
        List<Character> key = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        char last = input.charAt(0);
        int currCount = 1;
        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == last) {
                currCount++;
            } else {
                key.add(last);
                count.add(currCount);

                last = curr;
                currCount = 1;
            }
        }

        // add last
        key.add(last);
        count.add(currCount);

        // combine result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < key.size(); i++) {
            sb.append(key.get(i)).append(count.get(i));
        }

        return sb.toString();
    }
}
