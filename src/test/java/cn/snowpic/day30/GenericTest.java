package cn.snowpic.day30;

import org.junit.Test;

/**
 * @className: GenericTest
 * @description: day30's generic test
 * @author: lf
 * @date: 2019/5/30 8:34
 * @version: 1.0.0
 **/

public class GenericTest {
    void A(int a, int b) {
    }
    //void A(int b,int a){} doesn't to be a method overload

    /**
     * some math method about round
     */
    @Test
    public void test1() {
        System.out.println(Math.round(11.5f));
        System.out.println(Math.floor(11.5));
        System.out.println(Math.ceil(11.5));
    }


    static class A {
        protected int value;

        public A(int v) {
            setValue(v);//a.1 v:5
        }

        public void setValue(int value) {
            this.value = value;//a.2 v:10  //c.1 v:6  value:16
        }

        public int getValue() {
            try {
                value++;//b.1 value:11  //c.2 value:7
                return value;//b.2 r:11  //c.3 7
            } finally {
                this.setValue(value);//b.3 value:11  //c.4 value:7
                System.out.println(value);//b.4 sout:11 //c.5 sout:7
            }
        }
    }

    static class B extends A {

        public B() {
            super(5);//a.
            setValue(getValue() - 3);//b getValue:11 setValue:8
        }


        @Override
        public void setValue(int value) {
            super.setValue(2 * value);//c
        }
    }

    @Test
    public void test2() {
        System.out.println(new B().getValue());
        //1 22 34 17
    }

    @Test
    public void test3() {
        short s = 128;
        //0000 0000 1000 0000
        //强转精度损失
        //          1000 0000
        //第一位是负数
        byte b = (byte) s;

        System.out.println(b);
    }

    String str = new String("hello");

    char[] ch = {'a', 'b'};


    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'c';
        System.out.println(str);
        System.out.println(ch);
    }

    @Test
    public void test4() {
        GenericTest gt = new GenericTest();
        gt.change(gt.str, gt.ch);
        System.out.println(gt.str + " and ");
        System.out.println(gt.ch);
    }

    @Test
    public void test5() {
        int x = 3;
        if (x++ > 2) {
            System.out.println("xxxx" + x);
        }
    }
}
