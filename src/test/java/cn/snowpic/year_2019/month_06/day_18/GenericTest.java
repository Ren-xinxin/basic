package cn.snowpic.year_2019.month_06.month_06.day_18;

import org.junit.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * @className GenericTest
 * @description generic test
 * @author lf
 * @date 2019/6/18 12:18
 * @version 1.0.0
 **/

public class GenericTest {

    @Test
    public void test1() {
        System.out.println(Math.ceil(-0.5));//-0.0
        System.out.println(Math.round(-0.5));
        System.out.println(Math.round(0.5));
    }

    @Test
    public void test2() {
        Set<P> set = new HashSet<>();
        set.add(new P());
        set.add(new P());
        set.add(new P());
        set.add(new P());
        set.add(new P());
        System.out.println(set.size());
    }

    @Test
    public void test3() {
        try {

            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println(".......inner........");
            }

            throw new Exception();
        } catch (Exception e) {
            System.out.println(".......outer........");
        }
    }

    @Test
    public void test4() {
        File file = new File("");
        file.listFiles(f -> f.getName().equals(".java"));
        file.listFiles((File f) -> f.getName().equals(".java"));
    }

    @Test
    public void test5() {
        int b[][] = {{1}, {2, 3}, {2, 2, 2}};
        System.out.println(b[0][0]);
    }


    @Test
    public void test6() {
        new G().hi();
    }

    @Test
    public void test7() {
        P p1 = null;
        p1.hi();
        System.out.println(new Object() instanceof Object);
    }

    @Test
    public void test8() {
        new I("d");
    }
}

class H {
    private String name;

    public H(String name) {
        System.out.println("H");
    }

    public H() {
        System.out.println("no args constructor");
    }
}

class I extends H {

    public I(String name) {
        super("sss");
        System.out.println("I");
    }
}

class P {

    static void hi() {
        System.out.println("........hi........");
    }

    @Override
    public int hashCode() {
        System.out.println("hash code ... ");
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals");
        return true;
    }
}

class D {
    int i = 10;

    public class E {
        int j;

        {
            j = i;
        }
    }
}

class F {
    public int aa = 1;
}

class G extends F {
    public int aa = 2;

    public G() {
    }

    void hi() {
        System.out.println(super.aa);
    }
}