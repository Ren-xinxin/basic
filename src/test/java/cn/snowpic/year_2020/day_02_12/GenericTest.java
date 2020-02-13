/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_12;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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

    /**
     * counter binary
     *
     * @author lf
     * @time 2020-02-12 22:10:37
     * @param input input
     * @param eden eden
     * @param counter counter
     */
    private void countBinary(String input, int eden, AtomicInteger counter) {
        boolean isStart = true;
        int tepCounter = 1;
        for (int i = eden + 1; i < input.length(); i++) {
            boolean isOrigin = input.charAt(i) == input.charAt(eden);
            if (isStart && isOrigin) {
                tepCounter++;
            } else {
                if (isOrigin) return;
                if (isStart) isStart = false;
                if (--tepCounter == 0) {
                    counter.getAndIncrement();
                }
            }
        }
    }

    /**
     * count binary
     *
     * @author lf
     * @time 2020-02-12 22:10:43
     * @param input input
     * @return int
     */
    private int countBinary(String input) {
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < input.length(); i++) {
            countBinary(input, i, count);
        }
        return count.get();
    }

    @Test
    public void test2() {
        String input = "00110011";
        int count = countBinary(input);
        System.out.println("count = " + count);
    }

    /**
     * to lower case
     *
     * @author lf
     * @time 2020-02-12 23:18:55
     * @param input input
     * @return String
     */
    private String toLowerCase(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    @Test
    public void test3() {
        String input = "LOVELY";
        String lowerCase = toLowerCase(input);
        System.out.println("lowerCase = " + lowerCase);
    }

    /**
     * count morse code
     *
     * @author lf
     * @time 2020-02-12 23:31:39
     * @param inputs inputs
     * @return int
     */
    private int countMorseCode(String[] inputs) {
        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String input : inputs) {
            sb.setLength(0);
            for (char c : input.toCharArray()) {
                sb.append(morseCode[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    @Test
    public void test4() {
        String[] inputs = {"gin", "zen", "gig", "msg"};
        int count = countMorseCode(inputs);
        System.out.println("count = " + count);
    }
}
