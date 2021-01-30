/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_01.day_31;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            String target = sc.nextLine();
            String[][] matrix = new String[m][n];
            for (int i = 0; i < m; i++) {
                String row = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = String.valueOf(row.charAt(j));
                }
            }
            boolean flag = false;
            boolean[][] visited = new boolean[m][n];
            outer:
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String curr = matrix[i][j];
                    if (!target.startsWith(curr)) {
                        continue;
                    }
                    flag = query(i, j, matrix, "", target, visited);
                    if (flag) {
                        break outer;
                    }
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean query(int i, int j, String[][] matrix, String msg, String target, boolean[][] visited) {
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        msg += matrix[i][j];
        if (!target.startsWith(msg)) {
            return false;
        }
        if (target.equals(msg)) {
            return true;
        }
        if (query(i + 1, j, matrix, msg, target, visited)) {
            return true;
        }
        if (query(i - 1, j, matrix, msg, target, visited)) {
            return true;
        }
        if (query(i, j + 1, matrix, msg, target, visited)) {
            return true;
        }
        if (query(i, j - 1, matrix, msg, target, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
