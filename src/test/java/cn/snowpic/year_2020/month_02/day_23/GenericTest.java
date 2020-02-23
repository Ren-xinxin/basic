/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_23;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-23 16:44:40
 */
public class GenericTest {

    private String reverse(String input) {
        String[] split = input.trim().split("\\s+");
        int left = 0, right = split.length - 1;
        while (left < right) {
            // swap
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", split);
    }

    @Test
    public void test1() {
        String input = "the sky is blue";
        String reversed = reverse(input);
        System.out.println("reversed = " + reversed);
    }

    /**
     * compare version
     *
     * @author lf
     * @time 2020-02-23 17:17:34
     * @param version1 version1
     * @param version2 version2
     * @return int
     */
    private int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.min(split1.length, split2.length);
        int flag = 0;
        for (int i = 0; i < len; i++) {
            int v1 = Integer.parseInt(split1[i]);
            int v2 = Integer.parseInt(split2[i]);
            if (v1 > v2) {
                flag = 1;
                break;
            }
            if (v1 < v2) {
                flag = -1;
                break;
            }
        }
        return (split1.length == split2.length) ? flag :
                (flag == 0 ? (split1.length > split2.length ? 1 : -1) : flag);
    }

    @Test
    public void test2() {
        int compareVersion = compareVersion("1.1.0.23", "1.1.0");
        System.out.println("compareVersion = " + compareVersion);
    }

    /**
     * calculate
     *
     * @author lf
     * @time 2020-02-23 21:47:26
     * @param expression expression
     * @return int
     */
    private int calculate(String expression) {
        // deal with the blank letters
        expression = expression.replaceAll("\\s", "");
        if (!expression.matches("^[1-9]\\d*([+\\-*/][1-9]\\d*){1,10}")) {
            throw new RuntimeException("Illegal expression.");
        }
        String[] operatorNumbers = expression.split("[+\\-*/]");
        char[] operatorChars = expression.replaceAll("[^+\\-*/]", "").toCharArray();
        List<Character> operators = new ArrayList<>();
        for (char c : operatorChars) {
            operators.add(c);
        }
        boolean oneLevel = validateOneLevel(operators);
        if (!oneLevel) {
            dealMixLevel(operatorNumbers, operators);
        }
        return singleLevelOperate(operatorNumbers, operators);
    }

    /**
     * mix level operate
     *
     * @author lf
     * @time 2020-02-23 21:22:59
     * @param operatorNumbers operator numbers
     * @param operators operators
     */
    private void mixLevelOperate(String[] operatorNumbers, List<Character> operators) {
        for (int i = 0; i < operators.size(); i++) {
            Character operator = operators.get(i);
            if (level(operator) == 2) {
                operatorNumbers[i + 1] = operation(Integer.parseInt(operatorNumbers[i]), Integer.parseInt(operatorNumbers[i + 1]), operator) + "";
                operatorNumbers[i] = "0";
                operators.set(i, '+');
            }
        }
    }

    /**
     * deal mix level
     *
     * @author lf
     * @time 2020-02-23 21:39:02
     * @param operatorNumbers operator numbers
     * @param operators operators
     */
    private void dealMixLevel(String[] operatorNumbers, List<Character> operators) {
        while (!validateOneLevel(operators)) {
            mixLevelOperate(operatorNumbers, operators);
        }
    }

    /**
     * validate one level
     *
     * @author lf
     * @time 2020-02-23 21:16:50
     * @param operators operators
     * @return boolean
     */
    private boolean validateOneLevel(List<Character> operators) {
        return ((operators.contains('*') || operators.contains('/'))
                && !operators.contains('+') && !operators.contains('-'))
                || ((operators.contains('+') || operators.contains('-'))
                && !operators.contains('*') && !operators.contains('/'));
    }

    /**
     * single level operate
     *
     * @author lf
     * @time 2020-02-23 21:14:36
     * @param operatorNumbers operator numbers
     * @param operators operators
     * @return int
     */
    private int singleLevelOperate(String[] operatorNumbers, List<Character> operators) {
        int index = 0;
        int result = Integer.parseInt(operatorNumbers[0]);
        for (int i = 1; i < operatorNumbers.length; i++) {
            Character operator = operators.get(index++);
            int nextOperatorNumber = Integer.parseInt(operatorNumbers[i]);
            result = operation(result, nextOperatorNumber, operator);
        }
        return result;
    }

    /**
     * operation
     *
     * @author lf
     * @time 2020-02-23 21:12:06
     * @param oneOperatorNumber one operator number
     * @param nextOperatorNumber next operator number
     * @param operator operator
     * @return int
     */
    private int operation(int oneOperatorNumber, int nextOperatorNumber, Character operator) {
        switch (operator) {
            case '+': {
                oneOperatorNumber += nextOperatorNumber;
                break;
            }
            case '-': {
                oneOperatorNumber -= nextOperatorNumber;
                break;
            }
            case '*': {
                oneOperatorNumber *= nextOperatorNumber;
                break;
            }
            case '/': {
                oneOperatorNumber /= nextOperatorNumber;
                break;
            }
            default:
        }
        return oneOperatorNumber;
    }

    /**
     * level
     *
     * @author lf
     * @time 2020-02-23 20:57:11
     * @param operator operator
     * @return int
     */
    private int level(Character operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        return 2;
    }

    @Test
    public void test3() {
        System.out.println(calculate("2+3"));
        System.out.println(calculate("2+3*2/3"));
    }
}
