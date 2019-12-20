package cn.snowpic.year_2019.day_05_31;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @className: GenericTest
 * @description: generic test
 * @author: lf
 * @date: 2019/5/31 10:50
 * @version: 1.0.0
 **/

public class GenericTest {

    public class DD {
        //内部类
    }

    int main() {
        return 1;
    }

    @Test
    public void test1() {
        long i = 0xfffL;
        System.out.println(i);
        byte i1 = (byte) 128;
        System.out.println(i1);
        double d = 0.028367637d;
        System.out.println(Double.MAX_VALUE);
        double dMax = Double.MAX_VALUE;
        long lMax = Long.MAX_VALUE;
        System.out.println(Long.max(1L, 2L));
    }

    @Test
    public void test2() {
        byte b1 = 1, b2 = 2, b3, b6, b8;
        final byte b4 = 4, b5 = 6, b7;

        //b3 = (b1 + b2);// 1 + 2 即如果为int
        b6 = b4 + b5;
        //b8 = b1+ b4;//执行由低到高转型，结果为int
        //b8 = b4 + b1;//b1为转型为int
        //b7 = b2 + b5;
    }


    public static int i = 1;

    @Test
    public void test3() {
        int i = 10;
        i++;
        GenericTest.i++;
        GenericTest gt = new GenericTest();
        System.out.println(i + "   " + gt.i);
    }

    @Test
    public void test4() {
        HashMap hm = new HashMap();
        hm.put(null, null);

        Hashtable ht = new Hashtable();
        ht.values().forEach(System.out::println);
        try {
            ht.put(null, null);//运行错误，受检异常，NullPointerException
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    static final String MESSAGE = "taobao";

    @Test
    public void test5() {
        String b = "tao";
        final String c = "bao";
        String a = "tao" + c;


        System.out.println(a == MESSAGE);
        System.out.println((b + c) == MESSAGE);
        //字符串常量直接相加，因常量池已经存在该值，所以会指向同一区域
        //使用变量相加时，相当于创建一个StringBuilder() ,然后进行append
        //所以最终执向的是不同的地址
    }


    @Test
    public void test6() {
        new Z();// X
    }

    class X {
        Y y = new Y();

        public X() {
            System.out.println("X");
        }
    }

    class Y {
        public Y() {
            System.out.println("Y");
        }
    }

    class Z extends X {
        Y y = new Y();

        public Z() {
            System.out.println("Z");
        }
    }

    @Test
    public void test7() {
        new C();
    }

    @Test
    public void test8() {

    }
}


class Calf implements Cow {

    @Override
    public void drink() {

    }

    void drink1() {

    }

    protected void drink2() {

    }
}

interface B {
    int k = 10;
}

class A implements B {
    private int k;

    public static void main(String[] args) {
        int i;
        A a1 = new A();
        i = a1.k;
        System.out.println(i);
        // System.out.println(k);非静态成员变量无法被静态方法引用

        DDD ddd= new DDD();
    }

    static class DDD{
        public DDD() {
        }


    }
}
