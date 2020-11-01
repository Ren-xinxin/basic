/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_11.day_01;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        // 距行的绘图和檫出
        // n
        // d x1y1 x2y2
        // e x1y1 x2y2
        // d -1 1 1 -1
        //
        // 2
        // d 0 2 2 0
        // d -1 1 1 -1
        // 7
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = Integer.parseInt(sc.nextLine());
            int result = 0;
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int xi1 = Integer.parseInt(split[1]);
            int yi1 = Integer.parseInt(split[2]);
            int xi2 = Integer.parseInt(split[3]);
            int yi2 = Integer.parseInt(split[4]);
            result += (yi1 - yi2) * (xi2 - xi1);


            for (int i = 1; i < len; i++) {
                String line1 = sc.nextLine();
                String[] split1 = line1.split(" ");
                int x1 = Integer.parseInt(split1[1]);
                int y1 = Integer.parseInt(split1[2]);
                int x2 = Integer.parseInt(split1[3]);
                int y2 = Integer.parseInt(split1[4]);

                int ss = (y1 - y2) * (x2 - x1);

                int s = 0;

                if ((y2 <= yi1 && x1 <= xi1) || (y1 >= yi2 && x1 <= xi1)) {
                    int l = xi2 - x1;
                    int w = y1 - yi2;
                    s = l * w;
                } else if ((y1 >= yi2 && x2 >= xi1) || (y2 <= yi1 && x2 >= xi1)) {
                    int l = x2 - xi1;
                    int w = y1 - yi2;
                    s = l * w;
                }


                if ("d".equals(split1[0])) {
                    result += ss - s;
                } else if ("e".equals(split1[0])) {
                    result -= s;
                }
            }

            System.out.println(result);
        }
    }
}