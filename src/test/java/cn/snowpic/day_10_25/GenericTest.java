/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.day_10_25;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
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

        XSSFCell cell = workbook.createSheet("rxx")
                .createRow(0)
                .createCell(0);
        cell.setCellValue("meng weijin");

        // can do effective by this way.
        XSSFCellStyle cellStyle = workbook.createCellStyle();

        //XSSFCellStyle cellStyle = cell.getCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName("黑体");

        System.out.println("font = " + font.getFontName());

        cellStyle.setFont(font);

        cell.setCellStyle(cellStyle);

        FileOutputStream stream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.xlsx");
        workbook.write(stream);

        stream.close();

        // workbook.close();

    }
}
