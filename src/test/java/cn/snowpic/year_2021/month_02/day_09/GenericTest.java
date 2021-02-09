/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_02.day_09;

import org.junit.Test;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println(getMinPrintTimes("RRRGR"));
        System.out.println(getMinPrintTimes("RRRGRGG"));
    }

    private int getMinPrintTimes(String road) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= road.length(); i++) {
            String left = road.substring(0, i);
            String right = road.substring(i);
            int temp = getInvalid(left, 'G') + getInvalid(right, 'R');
            min = Math.min(min, temp);
        }
        return min;
    }

    private int getInvalid(String str, char target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test2() {
        System.out.println(divideApples(3, 3));
        System.out.println(divideApples(4, 4));
        System.out.println(divideApples(5, 5));
        System.out.println(divideApples(6, 6));
        System.out.println("===============================");
        System.out.println(divideApples2(3, 3));
        System.out.println(divideApples2(4, 4));
        System.out.println(divideApples2(5, 5));
        System.out.println(divideApples2(6, 6));
    }

    private int divideApples(int apples, int dishes) {
        int[][] arr = new int[apples + 1][dishes + 1];
        for (int i = 0; i <= apples; i++) {
            for (int j = 0; j <= dishes; j++) {
                if (i <= 1 || j <= 1) {
                    arr[i][j] = 1;
                    continue;
                }
                if (i < j) {
                    arr[i][j] = arr[i][i];
                } else {
                    arr[i][j] = arr[i - j][j] + arr[i][j - 1];
                }
            }
        }
        return arr[apples][dishes];
    }

    private int divideApples2(int apples, int dishes) {
        if (apples <= 1 || dishes <= 1) {
            return 1;
        }
        if (apples < dishes) {
            return divideApples2(apples, apples);
        } else {
            return divideApples2(apples - dishes, dishes) + divideApples2(apples, dishes - 1);
        }
    }
}
