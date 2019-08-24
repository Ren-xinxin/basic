package cn.snowpic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @className ListAdd
 * @description
 * @author lf
 * @time 2019/8/14 21:12
 **/

public class ListAdd1 {
    private volatile static List list = new ArrayList();

    private void add() {
        list.add("111");
    }

    private int size() {
        return list.size();
    }

    final static Object object = new Object();

    final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    public static void main(String[] args) {
        ListAdd1 listAdd = new ListAdd1();
        Thread t1 = new Thread(() -> {
            //synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    listAdd.add();
                    System.out.println("add a element ..");
                    if (i == 5) {
                        //object.notify();
                        COUNT_DOWN_LATCH.countDown();
                        System.out.println("has send a message");
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            //}
        });

        Thread t2 = new Thread(() -> {
            //synchronized (object){
                if (listAdd.size()!=5){
                    try {
                        //object.wait();
                        COUNT_DOWN_LATCH.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("this thread has received a message..");
                throw new RuntimeException("runtime exception..");
            //}
        });

        t2.start();
        t1.start();
    }
}
