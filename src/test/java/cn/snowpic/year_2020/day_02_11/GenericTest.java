/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.day_02_11;

import org.junit.Test;

public class GenericTest {

    /**
     * back
     *
     * @author lf
     * @time 2020-02-11 11:31:44
     * @param directions directions
     * @return boolean
     */
    private boolean back(String directions) {
        int[] position = {0, 0};
        for (int i = 0; i < directions.length(); i++) {
            forward(directions.charAt(i), position);
        }
        return position[0] == 0 && position[1] == 0;
    }

    /**
     * forward
     *
     * @author lf
     * @time 2020-02-11 11:31:20
     * @param charAt char at
     * @param position position
     */
    private void forward(char charAt, int[] position) {
        switch (charAt) {
            case 'U': {
                position[1]--;
                break;
            }
            case 'D': {
                position[1]++;
                break;
            }
            case 'L': {
                position[0]--;
                break;
            }
            case 'R': {
                position[0]++;
                break;
            }
            default:
        }
    }

    @Test
    public void test1() {
        boolean back = back("UD");
        System.out.println("back = " + back);

        boolean back1 = back("LL");
        System.out.println("back1 = " + back1);
    }
}
