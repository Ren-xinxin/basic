package cn.snowpic.year_2021.month_02.day_23;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(Arrays.toString(sortByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortByParity(new int[]{4, 5, 1, 3})));
        System.out.println("====================");
        System.out.println(Arrays.toString(sortByParity2(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortByParity2(new int[]{4, 5, 1, 3})));
    }

    private int[] sortByParity(int[] array) {
        int left = 0, right = array.length - 1;
        outer:
        while (left < right) {
            while (array[left] % 2 == 0) {
                if (++left >= right) {
                    break outer;
                }
            }
            while (array[right] % 2 != 0) {
                if (--right <= left) {
                    break outer;
                }
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        return array;
    }

    private int[] sortByParity2(int[] array) {
        int[] result = new int[array.length];
        int left = 0, right = array.length - 1;
        for (int num : array) {
            if (num % 2 == 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }
        return result;
    }

    @Test
    public void test2() {
        System.out.println(calc("2*3-4+(-5)"));
        System.out.println(calc("2*3-4+(1/5-5)"));
        System.out.println(calc("1+2+3"));
    }

    private String calc(String expression) {
        DecimalFormat df = new DecimalFormat("0.##");
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        while (true) {
            Matcher matcher = pattern.matcher(expression);
            if (!matcher.find()) {
                return df.format(calcStr(expression));
            }
            String group = matcher.group(1);
            expression = matcher.replaceFirst(String.valueOf(calcStr(group)));
        }
    }

    private double calcStr(String expr) {
        expr = expr.replaceAll("[ ]+", "");
        expr = expr.replaceAll("\\+-|-\\+", "-");
        expr = expr.replaceAll("-", "+-");
        return Arrays.stream(expr.split("\\+")).filter(str -> str != null && str.length() != 0)
                .map(this::getSecondValue).mapToDouble(Double::doubleValue).sum();
    }

    private double getSecondValue(String str) {
        String[] operations = str.replaceAll("([*/])", " $1 ").split(" ");
        double result = Double.parseDouble(operations[0]);
        for (int index = 1; index < operations.length; index++) {
            double next = Double.parseDouble(operations[index + 1]);
            if ("*".equals(operations[index])) {
                result *= next;
            }
            if ("/".equals(operations[index])) {
                result /= next;
            }
            index++;
        }
        return result;
    }
}
