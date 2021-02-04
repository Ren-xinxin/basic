/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.month_10.day_31;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/10/31 20:23
 */
public class GenericTest {
    @Test
    public void test1() throws Exception {
        Map<String, String> map = new HashMap<>(4);
        map.put("lover", "weijin");
        map.put("lover1", "weijin");
        map.put("lover2", "weijin");
        map.put("lover3", "weijin");
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] tables = (Object[]) tableField.get(map);
        System.out.println(tables == null ? 0 : tables.length);
    }

    @Test
    public void test2(){
        System.out.println("围巾超级可爱！");
    }
}
