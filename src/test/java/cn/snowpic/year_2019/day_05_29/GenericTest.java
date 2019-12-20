package cn.snowpic.year_2019.day_05_29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: GenericTest
 * @description: generic test
 * @author: lf
 * @date: 2019/5/29 22:20
 * @version: 1.0.0
 **/
@SuppressWarnings("all")
public class GenericTest {

    @Test
    public void test1() {
        System.out.println(AccountType.SAVING);
    }

    static {
        int x = 5;//a. 5
    }

    static int x, y; //b. 0 ,0

    static void myMethod() {
        System.out.println("xxxxxxxxxxxxxx" + x);
        y = x++ + ++x;//d1. -1 + 1(*******) = 0 x:1
        System.out.println("yyyyyyyyyyyyyy" + y);
    }

    @Test
    public void test2() {
        x--;//c. -1
        myMethod();//d.
        System.out.println(x + y + ++x);//e 1 + 0 + 2(***) = 3
    }


    /**
     * override equals method
     */
    @Test
    public void test3() {
        Object o = new Object() {
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };

        System.out.println(o.equals("fred"));//true
    }

    /**
     * list's extend and implement
     */
    @Test
    public void test4() {
        class A {
        }
        class B extends A {
        }
        class C extends A {
        }
        class D extends B {
        }

        //====================================

        List<A> aList = new ArrayList<>();

        List list = aList;//correct

        List<B> bList = new ArrayList<>();

        //List<A> aList1 = bList;//wrong

        List<Object> objects = new ArrayList<>();

        List list1 = objects;//correct

        List<D> dList = new ArrayList<>();

        List<? extends B> bs = dList;//correct

        List<? super D> ds = aList;//correct

        List<? extends A> as = dList;//correct

        List<? extends A> as1 = bs;//correect
    }
}


@SuppressWarnings("all")
enum AccountType {
    SAVING, FIXED, CURRENT;

    private AccountType() {
        System.out.println("this is a account type....");
    }
}
