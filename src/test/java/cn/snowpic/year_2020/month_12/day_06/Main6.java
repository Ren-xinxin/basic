/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_12.day_06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main6 {
    public static void main(String[] args) {
        // 1个2数组，0-1
        // 1具有扩散性
        // 将2个位置
        // m * n 初始扩散点位置，另一个点位置
        // 4,4,0,0,3,3
        // 3
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            int pointX1 = Integer.parseInt(split[2]);
            int pointY1 = Integer.parseInt(split[3]);
            int pointX2 = Integer.parseInt(split[4]);
            int pointY2 = Integer.parseInt(split[5]);

            int[][] arrays = new int[m][n];

            int times = 1;
            Set<List<Integer>> set = new HashSet<>();
            set.addAll(infect(arrays, pointX1, pointY1));
            set.addAll(infect(arrays, pointX2, pointY2));
            while (!check(arrays)) {
                Set<List<Integer>> temp = new HashSet<>();
                for (List<Integer> next : set) {
                    Integer x = next.get(0);
                    Integer y = next.get(1);
                    temp.addAll(infect(arrays, x, y));
                }
                set.addAll(temp);
                times += 1;
            }
            System.out.println(times);
        }
    }

    private static Set<List<Integer>> infect(int[][] arrays, int pointX, int pointY) {
        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<Integer>() {
            {
                add(pointX);
                add(pointY);
            }
        });
        arrays[pointX][pointY] = 1;
        int xIndex = arrays.length - 1;
        int yIndex = arrays[0].length - 1;
        int nextPointX = pointX + 1;
        if (nextPointX <= xIndex) {
            arrays[nextPointX][pointY] = 1;
            result.add(new ArrayList<Integer>() {
                {
                    add(nextPointX);
                    add(pointY);
                }
            });
        }
        int nextPointY = pointY + 1;
        if (nextPointY <= yIndex) {
            arrays[pointX][nextPointY] = 1;
            result.add(new ArrayList<Integer>() {
                {
                    add(pointX);
                    add(nextPointY);
                }
            });
        }
        int lastPointX = pointX - 1;
        if (lastPointX >= 0) {
            arrays[lastPointX][pointY] = 1;
            result.add(new ArrayList<Integer>() {
                {
                    add(lastPointX);
                    add(pointY);
                }
            });
        }
        int lastPointY = pointY - 1;
        if (lastPointY >= 0) {
            arrays[pointX][lastPointY] = 1;
            result.add(new ArrayList<Integer>() {
                {
                    add(pointX);
                    add(lastPointY);
                }
            });
        }
        return result;
    }

    private static boolean check(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
