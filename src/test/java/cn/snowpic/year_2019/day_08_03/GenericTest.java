package cn.snowpic.year_2019.day_08_03;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/3 23:03
 **/

public class GenericTest {

    /**
     * nio
     * @author lf
     * @time 2019/8/3 23:03
     */
    @Test
    public void test1() throws IOException {
        File file = new File("C:/Users/Administrator/Desktop/test.txt");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(100);
        int bytes = fc.read(bb);
        byte[] dest = new byte[bytes];
        System.arraycopy(bb.array(), 0, dest, 0, bytes);
        String s = new String(dest, Charset.forName("GB2312"));
        System.out.println(s);
    }
}
