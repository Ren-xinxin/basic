/*
 * Copyright(c) snowpic.cn 2019-2020. All rights reserved.
 */

package cn.snowpic.year_2020.month_03.day_10;

import org.dom4j.DocumentException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

/**
 * generic test
 *
 * @className GenericTest
 * @author Little Flower
 * @date 2020-03-10 21:29:07
 */
public class GenericTest {

    @Test
    public void test1() throws IOException, ParserConfigurationException, SAXException, DocumentException {
        URL url = new URL("https://product.pconline.com.cn/mb/msi/1212274_price.html");
        /*String uri = "https://ks.pconline.com.cn/product.shtml?q=3600cpu&scope=&smallType=cpu";
        HttpGet httpGet = new HttpGet(uri);
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStream content = entity.getContent();*/
        /*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(content);
        Element documentElement = document.getDocumentElement();
        NodeList title = documentElement.getElementsByTagName("title");*/

        //String result = EntityUtils.toString(entity);
        Document document = Jsoup.parse(url, 10000);
        Element price = document.getElementById("JsummaryPriceTrend");
        System.out.println("title = " + price);
        //System.out.println("result = " + result);
    }
}
