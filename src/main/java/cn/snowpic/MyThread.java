package cn.snowpic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className MyThread
 * @description
 * @author lf
 * @time 2019/8/11 16:39
 **/

public class MyThread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + ":" + count);
    }

    private static ExecutorService SERVICE = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        SERVICE.execute(thread);
        SERVICE.execute(thread);
        SERVICE.execute(thread);
        SERVICE.execute(thread);
        SERVICE.execute(thread);
        System.out.println(thread.count + "===========");
    }
}
