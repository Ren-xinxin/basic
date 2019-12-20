/*
package cn.snowpic.day_8_31;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/8/31 19:58
 **//*


public class GenericTest {

    @Test
    public void test1() throws Exception {
        ExcelWriter excelWriter = new ExcelWriter(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\2.xlsx")), ExcelTypeEnum.XLSX);
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 2048; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(i + "");
            }
            data.add(row);
        }
        WriteSheet writeSheet = new WriteSheet();
        writeSheet.setSheetName("TMD");

        excelWriter.write(data, writeSheet);

        WriteSheet writeSheet1 = new WriteSheet();
        writeSheet1.setSheetName("TMD2");

        List<List<Integer>> data1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                row.add(j);
            }
            data1.add(row);
        }
        excelWriter.write(data1, writeSheet1);
        excelWriter.finish();
    }
}
*/
