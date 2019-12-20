package cn.snowpic.year_2019.day_07_08;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/7/8 17:06
 **/

public class GenericTest {
    /**
     * test1
     * @author lf
     * @time 2019/7/8 17:06
     */
    @Test
    public void test1() {
        for (int i = 100; i < 1000; i++) {
            if (i == (Math.pow(i / 100, 3) + Math.pow(i / 10 % 10, 3) + Math.pow(i % 10, 3))) {
                System.out.println(i);
            }
        }

        for (int i = 1000; i < 10000; i++) {
            if (i == (Math.pow(i / 1000, 4) + Math.pow(i / 100 % 10, 4) + Math.pow(i / 10 % 10, 4) + Math.pow(i % 10, 4))) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void test2() {
        Socket socket = new Socket();

    }

    @Test
    public void test3() {
        int count = GenericTest.count();
        System.out.println(count);
        byte b = 100;
    }

    @Test
    public void test4() throws IOException {
        File file = new File("d:/2");
        File[] files = file.listFiles();
        HashSet<String> phones = new HashSet<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().endsWith(".bwcdr")) {
                BufferedReader br = new BufferedReader(new FileReader(files[i]));
                String number;
                int index = 0;
                while ((number = br.readLine()) != null) {
                    index++;
                    boolean add = phones.add(number);
                    if (!add) {
                        System.out.println(number + ":" + index + ":" + files[i].getName());
                    }
                }

            }
        }
    }

    @Test
    public void test5() {
        HashMap<String, String> map = new HashMap<>();
        //System.out.println();
        Assert.assertNotNull(map.put("1", "222"));
    }


    @Test
    public void test6() {
        int[] ss = new int[4];
        //System.out.println(ss[5]);
        System.out.println("".charAt(-1));
    }

    @Test
    public void test7() throws SQLException {
        Connection conn = DriverManager.getConnection("", "", "");
        PreparedStatement sssssssssss = conn.prepareStatement("sssssssssss");
        ResultSet set = sssssssssss.executeQuery();
        while (set.next()) {
            set.getInt(1);
        }
    }


    @Test
    public void test8() throws IOException {
        new Thread(() -> {
            try (ServerSocket socket = new ServerSocket(9999)) {
                Socket ss = socket.accept();
                ss.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                Socket s =  new Socket("localhost", 9999);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Test
    public void test9(){
        System.out.println("llllll".length());
    }

    private static int count() {
        try {
            return 5 / 0;
        } catch (Exception e) {
            return 2 * 3;
        } finally {
            return 3;
        }
    }
}
interface A{
    static void m1(){
        System.out.println("SB");
    }
}
