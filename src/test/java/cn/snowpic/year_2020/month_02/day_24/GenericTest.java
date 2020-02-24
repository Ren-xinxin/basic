/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_24;

import org.junit.Test;

import java.util.Stack;

public class GenericTest {

    private static class NestInteger {

        private int value;

        private NestInteger nextNode;

        public NestInteger(int value, NestInteger nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "[" + display() + "]";
        }

        /**
         * display
         *
         * @author lf
         * @time 2020-02-24 23:32:06
         * @return String
         */
        private String display() {
            return value + (nextNode == null ? "" : ",[" + nextNode.display() + "]");
        }
    }

    /**
     * analyze
     *
     * @author lf
     * @time 2020-02-24 23:17:29
     * @param input input
     * @return NestInteger
     */
    private NestInteger analyze(String input) {
        input = input.replaceAll("\\s+", "");
        input = input.contains("[") ? input : "[" + input + "]";
        if (!input.matches("^\\[\\d+(,\\[\\d+(,\\[\\d+(,\\[\\d+])?])?])?]$")) {
            throw new IllegalArgumentException("Input's format is incorrect.");
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                int end = input.indexOf(',', i);
                end = end == -1 ? input.indexOf(']', i) : end;
                String value = input.substring(i + 1, end);
                stack.push(Integer.valueOf(value));
            }
        }
        NestInteger child = null;
        while (!stack.isEmpty()) {
            child = new NestInteger(stack.pop(), child);
        }
        return child;
    }

    @Test
    public void test2() {
        NestInteger analyzed = analyze("[23,[34,[25,[34]]]]");
        System.out.println("analyzed = " + analyzed);
    }
}
