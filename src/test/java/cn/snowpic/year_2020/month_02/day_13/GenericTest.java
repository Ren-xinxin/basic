/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_13;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-13 21:24:10
 */
public class GenericTest {

    private String goatLatin(String sentence) {
        Set<Character> vowel = new HashSet<Character>() {{
            add('a');
            add('o');
            add('e');
            add('i');
            add('u');
            add('A');
            add('O');
            add('E');
            add('I');
            add('U');
        }};
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            int j = i + 1;
            char charAt = words[i].charAt(0);
            if (vowel.contains(charAt)) {
                words[i] += "ma";
            } else {
                words[i] = words[i].substring(1) + charAt + "ma";
            }
            while (j > 0) {
                words[i] += 'a';
                j--;
            }
        }
        return String.join(" ", words);
    }


    @Test
    public void test1() {
        String input = "I speak Goat Latin";
        String goatLatin = goatLatin(input);
        System.out.println("goatLatin = " + goatLatin);
    }
}
