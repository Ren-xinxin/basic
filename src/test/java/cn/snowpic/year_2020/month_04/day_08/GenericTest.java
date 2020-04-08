/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_08;

public class GenericTest {

    private int minSteps(String origin, final String target) {
        int max = Integer.MIN_VALUE;
        int originLeft = 0, originRight = 0, targetLeft = 0, targetRight = 0;
        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < origin.length(); j++) {
                if (origin.charAt(j) == target.charAt(i)) {
                    int ol = j - 1, or = j + 1, tl = i - 1, tr = i + 1;
                    int left = j, right = j;
                    int used = 1;
                    while (ol >= 0 && tl >= 0) {
                        if (origin.charAt(ol) == target.charAt(tl)) {
                            used++;
                            left = ol;
                            tl--;
                        }
                        ol--;
                    }
                    while (or < origin.length() && tr < target.length()) {
                        if (origin.charAt(or) == target.charAt(tr)) {
                            used++;
                            right = or;
                            tr++;
                        }
                        or++;
                    }
                    if (used > max) {
                        max = used;

                        originLeft = left;
                        originRight = right;

                        targetLeft = tl + 1;
                        targetRight = tr - 1;
                    }
                }
            }
        }

        int left = Math.max(originLeft, targetLeft);
        int middle = (originRight - originLeft + 1) - (targetRight - targetLeft + 1);
        int right = Math.max(origin.length() - 1 - originRight, target.length() - 1 - targetRight);
        return left + middle + right;
    }
}
