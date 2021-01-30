/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_01.day_26;

import java.util.Scanner;

public class GenericTest {

    public static void main(String[] args) {
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

    private static String convert(double num, int base) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            num *= base;
            arr[i] = (int) num;
            num -= arr[i];
        }
        StringBuilder sb = new StringBuilder("0.");
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}
