/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_12_29;

import org.junit.Test;

import java.util.Arrays;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/12/29 12:47
 */
public class GenericTest {

    @Test
    public void test1() {
        int[][] pic = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] picture = smoothPicture(pic);
        System.out.println("picture = " + Arrays.deepToString(picture));
    }

    /**
     * smooth picture
     * @author lf
     * @time 2019/12/29 12:49
     * @param pic pic
     */
    private int[][] smoothPicture(int[][] pic) {
        int[][] result = pic.clone();
        for (int i = 0; i < pic.length; i++) {
            for (int j = 0; j < pic[i].length; j++) {
                int startX = Math.max(j - 1, 0);
                int stopX = Math.min(j + 2, pic[i].length);
                int startY = Math.max(i - 1, 0);
                int stopY = Math.min(i + 2, pic.length);
                int count = 0;
                int sum = 0;
                for (int k = startX; k < stopX; k++) {
                    for (int l = startY; l < stopY; l++) {
                        sum += pic[k][l];
                        count++;
                    }
                }
                result[i][j] = (count == 0) ? 0 : (sum / count);
            }
        }
        return result;
    }
}