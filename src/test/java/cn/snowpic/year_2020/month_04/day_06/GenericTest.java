/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {

    /**
     * align words
     *
     * @author Little Flower
     * @date 2020-04-06 21:33:45
     * @param words words
     * @param maxLineWidth max line width
     * @return String[]
     */
    private String[] alignWords(String[] words, int maxLineWidth) {
        List<String> result = new ArrayList<>();
        int len = 0;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int except = len + 1 + words[i].length();
            if (except > maxLineWidth || i == words.length - 1) {
                dealElement(words, maxLineWidth, result, start, sb, i);
                start = i;
                len = words[i].length();
            } else {
                len = except;
            }
        }
        // deal last element
        dealLastElement(maxLineWidth, result, sb);
        return result.toArray(new String[0]);
    }

    /**
     * deal last element
     *
     * @author Little Flower
     * @date 2020-04-06 21:33:23
     * @param maxLineWidth max line width
     * @param result result
     * @param sb sb
     */
    private void dealLastElement(int maxLineWidth, List<String> result, StringBuilder sb) {
        int last = result.size() - 1;
        String lastElement = result.get(last);
        String[] split = lastElement.trim().split("[ ]+");
        String str = String.join(" ", split);
        int remain = maxLineWidth - str.length();
        sb.setLength(0);
        for (int i = 0; i < remain; i++) {
            sb.append(" ");
        }
        str += sb.toString();
        result.set(last, str);
    }

    /**
     * deal element
     *
     * @author Little Flower
     * @date 2020-04-06 21:33:28
     * @param words words
     * @param maxLineWidth max line width
     * @param result result
     * @param start start
     * @param sb sb
     * @param index index
     */
    private void dealElement(String[] words, int maxLineWidth, List<String> result, int start, StringBuilder sb, int index) {
        // recalculate index
        index = index == words.length - 1 ? words.length : index;
        int gapCount = index - 1 - start;
        String[] copied = Arrays.copyOfRange(words, start, index);
        int len = 0;
        for (String s : copied) {
            len += s.length();
        }
        if (gapCount == 0) {
            sb.setLength(0);
            for (int j = 0; j < (maxLineWidth - len); j++) {
                sb.append(" ");
            }
            String newStr = String.join("", copied);
            result.add(newStr + sb.toString());
        } else {
            int gap = (maxLineWidth - len) / gapCount;
            sb.setLength(0);
            for (int j = 0; j < gap; j++) {
                sb.append(" ");
            }
            String delimiter = sb.toString();
            String newStr = String.join(delimiter, copied);
            int remain = maxLineWidth - newStr.length();
            // right
            sb.setLength(0);
            for (int j = 0; j < remain / 2; j++) {
                sb.append(" ");
            }
            newStr += sb.toString();
            // left
            remain = maxLineWidth - newStr.length();
            sb.setLength(0);
            for (int j = 0; j < remain / 2; j++) {
                sb.append(" ");
            }
            newStr = sb.toString() + newStr;
            result.add(newStr);
        }
    }

    @Test
    public void test1() {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] alignWords = alignWords(words, 16);
        System.out.println("alignWords = " + Arrays.toString(alignWords));
    }
}
