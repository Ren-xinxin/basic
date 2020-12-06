/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_12.day_06;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        //
        // n[str] 方框内的str重复n ，a-z
        // 3[k]2[mn]
        // 3[2[k]]2[mn]
        // kkkmnmn
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line = line.replaceAll("[]](\\d)", " $1");
            line = line.substring(0, line.length() - 1);
            String[] split = line.split(" ");
            StringBuilder sb = new StringBuilder();
            append(split, sb);
            System.out.println(sb.toString());
        }
    }

    private static void append(String[] split, StringBuilder sb) {
        for (String str : split) {
            if (str.matches(".*[]].*")) {
                String temp = str.replaceAll("[]](\\d)", " $1");
                temp = temp.replaceAll("^[\\[](.*)$", "$1");
                int times = Integer.parseInt(temp.substring(0, temp.indexOf("[")));
                temp = temp.substring(temp.indexOf("[") + 1);
                temp = temp.substring(0, temp.length() - 1);
                String[] ss = temp.split(" ");
                for (int i = 0; i < times; i++) {
                    append(ss, sb);
                }
            } else {
                if ("".equals(str)) {
                    continue;
                }
                String[] split1 = str.split("[\\[]");
                int count = Integer.parseInt(split1[0]);
                for (int i = 0; i < count; i++) {
                    sb.append(split1[1]);
                }
            }
        }
    }
}
