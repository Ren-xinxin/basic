/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_19;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-19 21:05:29
 */
public class GenericTest {

    /**
     * simplify
     *
     * @author lf
     * @time 2020-02-19 23:32:15
     * @param input input
     * @return String
     */
    private String simplify(String input) {
        Stack<String> stack = new Stack<>();
        String[] split = input.split("/");
        for (String s : split) {
            if (s.length() == 0) {
                continue;
            }
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!s.equals(".")) {
                stack.push(s);
            }
        }
        return stack.isEmpty() ? "/" : String.join("/", new ArrayList<>(stack));
    }

    @Test
    public void test1() {
        String input = "/a/./b/../../c/";
        String simplify = simplify(input);
        System.out.println("simplify = " + simplify);

        System.out.println(simplify("/home/.."));
    }
}