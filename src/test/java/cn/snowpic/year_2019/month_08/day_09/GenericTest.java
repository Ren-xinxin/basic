package cn.snowpic.year_2019.month_08.month_08.day_09;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/9 0:03
 **/

public class GenericTest {

    @Test
    public void test1(){
        int[] list = {2,4,6,8,10};
        List<Integer> asList = Arrays.asList(1,3,5,7,8,10);
        List<Integer> collect = asList.stream().collect(Collectors.toList());
        collect.add(11);
    }
}
