/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    /**
     * fibonacci
     *
     * @author Little Flower
     * @date 2020-03-09 22:46:51
     * @param input input
     * @return List<Integer>
     */
    private List<Integer> fibonacci(String input) {
        List<Integer> result = new ArrayList<>();
        validate(input, 0, null, result);
        return result;
    }

    /**
     * validate
     *
     * @author Little Flower
     * @date 2020-03-09 22:46:45
     * @param input input
     * @param currentIndex current index
     * @param currentSequence current sequence
     * @param result result
     */
    private void validate(String input, final int currentIndex, List<Integer> currentSequence, List<Integer> result) {
        if (currentSequence != null) {
            if (currentIndex >= input.length()) {
                if (isFibonacci(currentSequence)) {
                    result.addAll(currentSequence);
                }
                return;
            }
        }
        for (int i = 1; i <= input.length(); i++) {
            currentSequence = currentIndex == 0 ? new ArrayList<>() : currentSequence;
            int endIndex = Math.min(currentIndex + i, input.length());
            String strValue = input.substring(currentIndex, endIndex);
            if (!strValue.matches("[1-9]\\d*")) return;
            Integer currentValue = Integer.valueOf(strValue);
            //noinspection ConstantConditions
            currentSequence.add(currentValue);
            validate(input, endIndex, currentSequence, result);
            if (result.size() > 0) return;
            currentSequence.remove(currentValue);
        }
    }

    /**
     * is fibonacci
     *
     * @author Little Flower
     * @date 2020-03-09 22:39:15
     * @param sequence sequence
     * @return boolean
     */
    private boolean isFibonacci(List<Integer> sequence) {
        if (sequence.size() < 3) {
            return false;
        }
        for (int i = 2; i < sequence.size(); i++) {
            if (sequence.get(i) != (sequence.get(i - 1) + sequence.get(i - 2))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        List<Integer> fibonacci = fibonacci("1101111");
        System.out.println("fibonacci = " + fibonacci);
    }
}
