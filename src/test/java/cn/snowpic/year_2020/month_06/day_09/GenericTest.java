/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_06.day_09;

import org.junit.Test;

import java.util.Scanner;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println("请输入一个3位数字");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String next = scanner.next();
            String[] split = next.split("");
            int target = Integer.parseInt(next);
            int sum = 0;
            int pow = 0;
            for (int index = split.length - 1; index >= 0; index--) {
                sum += Integer.parseInt(split[index]) * Math.pow(10, pow++);
            }
            if (sum == target) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
}