package Lab3.Data;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Source {
    /*
     获取数据方法
      */
    public static List<Double> getData(int row) {
        List<Double> simple1 = new ArrayList<Double>();
        File f = new File("C:\\data.xls");

        String s = null;
        try {
            Workbook book = Workbook.getWorkbook(f);//
            Sheet sheet = book.getSheet(0); //获得第一个工作表对象
            for (int i = 1; i < sheet.getRows() - 1; i++) {
                Cell cell = sheet.getCell(row - 1, i); //获得单元格
                s = cell.getContents() + " " + i + " " + sheet.getRows();
                simple1.add(Double.parseDouble(cell.getContents()));
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return simple1;
    }
}
