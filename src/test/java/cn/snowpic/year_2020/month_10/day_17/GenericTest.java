/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_10.day_17;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GenericTest {
    @Test
    public void test1() {
        System.out.println("hello");
        InnerClassSingleton.getInstance();
    }

    @Test
    public void test2() {
        final EnumSingleton instance = EnumSingleton.INSTANCE;
        System.out.println(instance.name());
    }

    private static class Output implements Serializable{
        private static final long serialVersionUID = -5801445481753389056L;
        transient int age;
    }

    @Test
    public void test3() throws IOException {
        final Output output = new Output();
        output.age = 15;

        final ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:/out"));
        outputStream.writeObject(output);

        outputStream.flush();
    }

    @Test
    public void test4() throws IOException, ClassNotFoundException {
        final ObjectInputStream stream = new ObjectInputStream(new FileInputStream("d:/out"));
        final Object object = stream.readObject();
        final Output obj = (Output) object;
        System.out.println(obj.age);
    }
}