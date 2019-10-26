/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_10_25;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/10/25 21:17
 */
public class GenericTest {

    @Test
    public void test1() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        workbook.createSheet("rxx")
                .createRow(0)
                .createCell(0)
                .setCellValue("meng weijin");
        FileOutputStream stream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.xlsx");
        workbook.write(stream);

        // stream.close();

        // workbook.close();

    }
}
