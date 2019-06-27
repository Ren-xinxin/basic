package cn.snowpic.day_6_3;

import com.swetake.util.Qrcode;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @className: GenericTest
 * @description: generic test
 * @author: lf
 * @date: 2019/6/3 8:49
 * @version: 1.0.0
 **/

public class GenericTest {

    /**
     * step of using JDBC
     *
     * @throws SQLException sql exception
     * @throws IOException  IO exception
     */
    @Test
    public void test1() throws SQLException, IOException {

        //1
        InputStream is = GenericTest.class.getClassLoader().getResourceAsStream("");

        //2
        Properties ppt = new Properties();

        //3
        ppt.load(is);

        String url = "";

        //4
        Connection connection = DriverManager.getConnection(url, ppt);

        PreparedStatement statement = connection.prepareStatement("");
        //5
        statement.execute();
    }

    /**
     * three ways that can create one new thread
     *
     * @throws Exception exception
     */
    @Test
    public void test2() throws Exception {
        System.out.println("A" + System.currentTimeMillis());
        Thread th = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ok this world");
            System.out.println("B" + System.currentTimeMillis());
        });

        th.start();

        Runnable runnable = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("You are stupid");
            System.out.println("C" + System.currentTimeMillis());
        };
        new Thread(runnable).start();

        Callable callable = () -> {
            Thread.sleep(100);
            System.out.println("Just so so");
            System.out.println("D" + System.currentTimeMillis());
            return null;
        };

        //the class implements callable must be invoked by future task
        FutureTask task = new FutureTask<Object>(callable);
        new Thread(task).start();

        System.out.println("E" + System.currentTimeMillis());
        Thread.sleep(3000);
    }

    /**
     * create a QR code
     * F5:
     * F6:
     * F7:
     * F8:
     */
    @Test
    public void test3() throws IOException {
        String content = "123456";
        String imgPath = "d:/1.png";
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        qrcode.setQrcodeVersion(5);
        byte[] contentBytes = content.getBytes("gb2312");
        BufferedImage bufferedImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.clearRect(0, 0, 600, 600);
        graphics.setColor(Color.BLACK);
        int pixOff = 2;
        if (contentBytes.length > 0 && contentBytes.length < 800) {
            boolean[][] codeQut = qrcode.calQrcode(contentBytes);
            for (int i = 0; i < codeQut.length; i++) {
                for (int j = 0; j < codeQut.length; j++) {
                    if (codeQut[j][i]) {
                        graphics.fillRect(j * 16 + pixOff, i * 16 + pixOff, 16, 16);
                    }
                }
            }
        }
        graphics.dispose();
        bufferedImage.flush();
        ImageIO.write(bufferedImage, "png", new File(imgPath));
    }

    @Test
    public void test4() {
        System.out.println((-8) << 1);
    }

    @Test
    public void test5() {
        String s = "中";
        char c = '新';
        String s1 = new String(new char[]{c});
        System.out.println(s1);
        System.out.println(s1.getBytes(Charset.defaultCharset()).length);
        System.out.println(Charset.defaultCharset());
        System.out.println(c);
    }

    @Test
    public void test6() {
        Integer i = 6;
        int j = i;
        System.out.println(j);
    }

    @Test
    public void test7() {
        if (true)
            System.out.println("sssssssss");
        else
            System.out.println("ssssssssssssssssddddddddd");
    }

    @Test
    public void test8() {
        StringBuffer sb = new StringBuffer();
        sb.append("sssss");
        sb.append("rxx");
        System.out.println(sb.toString());

        int a = '2';
        System.out.println(a);
    }

    @Test
    public void test9() {
        B bb = new B();
    }

    @Test
    public void test10() {
        float f = 1.2f;
        int a = (int) f;
        System.out.println(a);
    }
}

class B {
    public static B b = new B();
    public static B c = new B();

    {
        System.out.println("normal code block");
    }

    static {
        System.out.println("static code block");
    }
}

interface A {
    abstract void A();
}
