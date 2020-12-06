/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_12.day_06;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        // 1.有n正正整数序列
        // 1,2,3,4,2
        // sum 6
        //
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            int sum = scanner.nextInt();
            int[] nums = new int[split.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            int len = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int temp = 0;
                    for (int k = i; k <= j; k++) {
                        temp += nums[k];
                    }
                    int tempLen = j - i + 1;
                    if (temp == sum && tempLen > len) {
                        len = tempLen;
                    }
                }
            }
            System.out.println(len);
        }
    }
}
