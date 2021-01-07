/*
 * Copyright(c) snowpic.cn 2019-2021. All rights reserved.
 */

package cn.snowpic.year_2021.month_01.day_07;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test1() {
        System.out.println("tianshdhsidk ww idsijdskwkdsk".hashCode());
        System.out.println("dsdwdsddwdsdstianshdhsidk ww idsdssijdskwkdsk".hashCode());
        System.out.println("tianshdhsidk ww idsijdskwkdsk".hashCode());
        int abs ="sdkwddsssdsddswddswwwdsdsddwdssdsddedsdedssdejikjdsjdiwji dsdwdsddsddsdwdsddsdssdwdsddsdwdsijdkjskdjiwjidjskjdiw"
                        .hashCode();
        System.out.println(abs);
        System.out.println(String.valueOf( Math
                .abs(abs)).length());
        System.out.println(String.valueOf(Math.abs("xasaqdsdwcfsdsdsdsdsdddsdwdsddssddsdssdsddwwdssddwdssdsdswwdssd12345678901234".hashCode())).length());
    }
}
