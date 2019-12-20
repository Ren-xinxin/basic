package cn.snowpic.year_2019.day_06_26;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @className GenericTest
 * @description Generic test
 * @author lf
 * @time 2019/6/26 8:31
 **/
@SuppressWarnings("ALL")
public class GenericTest {

    /**
     * test1
     * @author lf
     * @time 2019/6/27 17:47
     */
    @Test
    public void test1() {
        Float f1 = 1.0f;
        Float f2 = 1.0f;
        Double d1 = 1.0;
        boolean b1 = f1.equals(f2);
        boolean b2 = f1.equals(d1);
        System.out.println();
    }

    /**
     * test2
     * @author lf
     * @time 2019/6/27 13:55
     */
    @Test
    public void test2() {
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size() < 20) {
            set.add(random.nextInt(20) + 1);
        }
        System.out.println(set);
    }

    /**
     * crate a array with 20 phone numbers
     * @author lf
     * @time 2019/6/27 17:52
     */
    @Test
    public void test3() {
        //create phones set
        Set<String> phones = new HashSet<>();
        //create random object
        Random random = new Random();
        //while phones' size less than 20
        while (phones.size() < 20) {
            //create string builder object
            StringBuilder sb = new StringBuilder();
            //append prefix
            sb.append(13);
            //append numbers
            for (int i = 0; i < 9; i++) {
                sb.append(random.nextInt(10));
            }
            //add phone number to the set
            phones.add(sb.toString());
        }
        //print phones
        System.out.println(phones);
        //get phones' stream
        phones.stream()
                //get phone's number length
                .map(String::length)
                //collect to list
                .collect(Collectors.toList())
                //print the specific phone number length
                .forEach(System.out::println);
    }

    /**
     * test4
     * @author lf
     * @time 2019/6/28 8:55
     */
    @Test
    public void test4() {
        int[] ages = {2, 4, 6, 2, 32, 43, 1, 5};
        Arrays.sort(ages);
        for (int age : ages) {
            System.out.println(age);
        }
    }
}
