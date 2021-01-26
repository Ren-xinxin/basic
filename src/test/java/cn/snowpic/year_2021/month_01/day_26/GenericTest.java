/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_01.day_26;

import org.junit.Test;

import java.util.Scanner;

public class GenericTest {

    @Test
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if ("0 0".equals(line)) {
                return;
            }
            String[] split = line.split(" ");
            double num = Double.parseDouble(split[0]);
            int base = Integer.parseInt(split[1]);
            String result = convert(num, base);
            System.out.println("result = " + result);
        }
    }

    private String convert(double num, int base) {
        int[] arr = new int[10];
        return null;
    }
}
