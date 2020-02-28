/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_28;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-28 20:08:38
 */
public class GenericTest {

    /**
     * optimal division
     *
     * @author lf
     * @time 2020-02-28 20:41:49
     * @param numbers numbers
     * @return String
     */
    public String optimalDivision(int[] numbers) {
        StringJoiner sj = new StringJoiner("/");
        for (int i = 1; i < numbers.length; i++) {
            sj.add(numbers[i] + "");
        }
        return String.format("%d/(%s)", numbers[0], sj.toString());
    }

    @Test
    public void test1() {
        int[] array = {5, 8, 2};
        String division = optimalDivision(array);
        System.out.println("division = " + division);
    }

    /**
     * next bigger
     *
     * @author lf
     * @time 2020-02-28 22:14:00
     * @param input input
     * @return int
     */
    private int nextBigger(int input) {
        String value = String.valueOf(input);
        char[] chars = value.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                char temp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = temp;
                return Integer.parseInt(new String(chars));
            }
        }
        return -1;
    }

    @Test
    public void test2() {
        int bigger1 = nextBigger(12);
        int bigger2 = nextBigger(21);
        System.out.println("bigger1 = " + bigger1);
        System.out.println("bigger2 = " + bigger2);
    }

    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2020-02-29 00:00:00");
        System.out.println("date = " + date);

        Calendar calendar = Calendar.getInstance();
        //calendar.set(1996, Calendar.JANUARY, 6);
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println("calendar = " + calendar.getTime());
    }
}
