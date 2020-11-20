/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        // 每个小朋友都知道自己时候前面小朋友同班
        // 6/N
        // 输入3/N 4/Y
        // 输出
        // 1/N 2/Y 3/N 4/Y
        // 1 2
        // 3 4
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] children = line.split(" ");
            List<Integer> class1 = new ArrayList<>();
            List<Integer> class2 = new ArrayList<>();

            boolean isClass1 = true;

            class1.add(Integer.parseInt(children[0].split("/")[0]));

            for (int i = 1; i < children.length; i++) {
                String[] prop = children[i].split("/");
                Integer num = Integer.parseInt(prop[0]);
                String isOneClass = prop[1];
                if ("Y".equals(isOneClass) && isClass1) {
                    class1.add(num);
                } else if ("N".equals(isOneClass) && isClass1) {
                    class2.add(num);
                    isClass1 = false;
                } else if ("Y".equals(isOneClass)) {
                    class2.add(num);
                    isClass1 = false;
                } else if ("N".equals(isOneClass)) {
                    class1.add(num);
                    isClass1 = true;
                }
            }

            List<String> c1 = class1.stream().sorted().map(String::valueOf).collect(Collectors.toList());
            List<String> c2 = class2.stream().sorted().map(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(" ", c1));
            System.out.println(String.join(" ", c2));
        }
    }
}