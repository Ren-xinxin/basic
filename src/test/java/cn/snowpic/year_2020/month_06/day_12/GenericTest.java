/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_06.day_12;

import cn.snowpic.model.RequestVo;
import cn.snowpic.util.DisableSslUtils;
import com.alibaba.fastjson.JSON;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class GenericTest {

    @Test
    public void test1() throws IOException, KeyManagementException, NoSuchAlgorithmException {
        Connection connection = Jsoup.connect("https://127.0.0.1:8081/provider/hello-api/ok");
        DisableSslUtils.disableSslVerification();
        RequestVo vo = RequestVo.builder()
                .age(11)
                .name("rxx")
                .hobbies(new String[]{"sb", "db"})
                .build();


        String params = JSON.toJSONString(vo);

        Connection.Response response = connection.method(Connection.Method.POST)
                .header("Content-Type", "application/json")
                .requestBody(params)
                .execute();

        String body = response.body();
        System.out.println("body = " + body);
    }
}
