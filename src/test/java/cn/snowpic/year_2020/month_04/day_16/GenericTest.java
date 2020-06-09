/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_04.day_16;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericTest {

    private AtomicInteger count = new AtomicInteger();

    @Test
    public void test1() throws InterruptedException, IOException {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 100000; i++) {
            pool.execute(() -> {
                try {
                    Connection connect = Jsoup.connect("http://ershiyi.ejylboc.cn:5121/home/login")
                            .method(Connection.Method.POST)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36")
                            .header("Cookie", "ASP.NET_SessionId=kif3t3lc5nb333mufp24gdcg")
                            .data(new HashMap<String, String>() {{
                                put("QQhao", random.nextInt(999999999) + "");
                                put("QQmima", random.nextInt(999999999) + "");
                            }});
                    Document document = connect.post();
                    if (document != null) {
                        System.out.println(count.incrementAndGet());
                    }
                } catch (IOException e) {

                }
            });
        }
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
