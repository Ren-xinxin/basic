package cn.snowpic;

import java.util.ArrayList;
import java.util.List;

/**
 * @className ListAdd
 * @description
 * @author lf
 * @time 2019/8/14 21:12
 **/

public class ListAdd {
    private volatile static List list = new ArrayList();

    private void add() {
        list.add("111");
    }

    private int size() {
        return list.size();
    }

    public static void main(String[] args) {
        ListAdd listAdd = new ListAdd();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                listAdd.add();
                System.out.println("add a element ..");
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (listAdd.size() == 5) {
                    //System.out.println("this thread has received a message..");
                    throw new RuntimeException("runtime exception..");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
