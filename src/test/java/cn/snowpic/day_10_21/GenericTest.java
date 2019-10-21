/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_10_21;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lf
 * @className GenericTest
 * @description
 * @time 2019/10/21 21:23
 */
public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2019/10/21 21:23
     */
    @Test
    public void test1() {
        String[] arr = {"abc", "bcd", "bde", "dbg"};

        List<String> collect = Arrays.stream(arr)
                .map(ar -> ar.replaceAll("b", "gg"))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}
