/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_07;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericTest {

    /**
     * construct
     *
     * @author lf
     * @time 2020-02-07 19:41:14
     * @param ransom ransom
     * @param magazine magazine
     * @return boolean
     */
    private boolean construct(String ransom, String magazine) {
        List<Integer> chars = new StringBuilder(magazine)
                .chars()
                .boxed()
                .collect(Collectors.toList());
        char[] ransoms = ransom.toCharArray();
        for (char r : ransoms) {
            if (!chars.remove(Integer.valueOf(r))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        boolean construct1 = construct("aa", "ab");
        System.out.println("construct1 = " + construct1);

        boolean construct2 = construct("baa", "aba");
        System.out.println("construct1 = " + construct2);
    }

    /**
     * reverse vowel
     *
     * @author lf
     * @time 2020-02-07 20:05:21
     * @param input input
     * @return String
     */
    private String reverseVowel(String input) {
        Set<Character> vowel = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !vowel.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowel.contains(chars[right])) {
                right--;
            }
            if (left < right) {
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
    public void test2() {
        String input = "LeetCode";

        String reverseVowel = reverseVowel(input);
        System.out.println("reverseVowel = " + reverseVowel);
    }
}
