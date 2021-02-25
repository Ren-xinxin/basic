/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_01;

import org.junit.Test;

import java.util.*;

public class GenericTest {

    @Test
    public void test1() {
        String input = "{[()]}";
        boolean bracketMatch = completeBracketMatch(input);
        System.out.println("bracketMatch = " + bracketMatch);
    }

    /**
     * complete bracket match
     *
     * @author lf
     * @time 2020-02-01 22:06:03
     * @param input input
     * @return boolean
     */
    private boolean completeBracketMatch(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            Character startChar = map.get(current);
            if (startChar != null) {
                if (stack.isEmpty() || stack.pop() != startChar) {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }
        return stack.isEmpty();
    }
}
