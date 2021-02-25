/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_11;

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

    /**
     * palindrome
     *
     * @author lf
     * @time 2020-02-11 11:38:33
     * @param input input
     * @return boolean
     */
    private boolean palindrome(String input, int left, int right, boolean isFirstFailed) {
        while (left < right) {
            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                if (!isFirstFailed) {
                    return false;
                }
                boolean palindrome1 = palindrome(input, left + 1, right, false);
                boolean palindrome2 = palindrome(input, left, right - 1, false);
                if (palindrome1) {
                    System.out.println("remove left " + input.charAt(left));
                    return true;
                }
                if (palindrome2) {
                    System.out.println("remove right " + input.charAt(right));
                    return true;
                }
                return false;
            }
        }
        return true;
    }


    /**
     * palindrome
     *
     * @author lf
     * @time 2020-02-11 21:47:42
     * @param input input
     * @return boolean
     */
    private boolean palindrome(String input) {
        return palindrome(input, 0, input.length() - 1, true);
    }

    @Test
    public void test2() {
        String input = "aba";
        boolean palindrome1 = palindrome(input);
        System.out.println("palindrome1 = " + palindrome1);

        boolean palindrome = palindrome("abcbda");
        System.out.println("palindrome = " + palindrome);
    }
}
