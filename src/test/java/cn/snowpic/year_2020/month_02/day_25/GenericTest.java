/*
 * Copyright(c) snowpic.cn 2019-2020.All rights reserved.
 */

package cn.snowpic.year_2020.month_02.day_25;

import org.junit.Test;

/**
 * generic test
 *
 * @className GenericTest
 * @author lf
 * @time 2020-02-25 21:45:38
 */
public class GenericTest {

    @Test
    public void test1() {
        int i = Integer.parseInt("2f", 16);
        System.out.println("i = " + i);
    }

    /**
     * validate ip
     *
     * @author lf
     * @time 2020-02-25 22:57:41
     * @param input input
     * @return String
     */
    private String validateIp(String input) {
        input = input.toLowerCase();
        if (input.matches("^(1\\d{2}|2[0-5]{2}|[1-9]\\d?)(\\.(1\\d{2}|2[0-5]{2}|[1-9]\\d?)){3}$")) {
            return "IPV4";
        }
        if (!input.matches("^00.*|.*:00.*$") && input.matches("^[0-9a-f]+(:[0-9a-f]+){7}$")) {
            return "IPV6";
        }
        return "NEITHER";
    }

    @Test
    public void test2() {
        String input1 = "172.16.254.1";
        String ip1 = validateIp(input1);
        System.out.println("ip1 = " + ip1);

        String input2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String ip2 = validateIp(input2);
        System.out.println("ip2 = " + ip2);
    }
}
