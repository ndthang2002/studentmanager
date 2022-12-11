package crudstudent;

import java.awt.print.Book;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat.Style;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.DARK_BLUE;
import org.apache.poi.hssf.util.HSSFColor.GREEN;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.hssf.util.HSSFColor.RED;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import datastudent.Student;
import javafx.scene.chart.BubbleChart;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.Background;

public class WriteReadExcel {
  public  static final int COLUMN_INDEX_ID =0;
  public  static final int COLUMN_INDEX_TITLE     =1;
  public  static final int COLUMN_INDEX_PRICE     =2;
  public  static final int COLUMN_INDEX_QUANTITY  =3;
  public  static final int COLUMN_INDEX_TOTAL     =4;
  private static CellStyle cellStyleFormatNumber = null;
  
  public static void writeExcel(List<Student> lists ) throws IOException {
    
    XSSFWorkbook workbook =  new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("student");
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
    
    Map<Integer , Object[]> data = new HashMap<Integer,Object[]>();
    for(int i=1;i<lists.size();i++) {
          data.put(i, new Object[] {lists.get(i).getIdStudent(),lists.get(i).getName(),lists.get(i).getLop()});

    }
    data.put(0, new Object[] {"id","name","lop"});
   
    Set<Integer> keyset = data.keySet(); 
    int rownum=0;
    for(Integer key : keyset) {
      Row row = sheet.createRow(rownum++);
      Object[] objArr = data.get(key);
      int cellnum =0;
      for(Object obj : objArr) {
        Cell cell = row.createCell(cellnum++);
        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setFillForegroundColor(HSSFColorPredefined.DARK_GREEN.getIndex());
        cellStyle.setFillBackgroundColor(HSSFColorPredefined.YELLOW.getIndex());
     
        cell.setCellStyle(cellStyle);
        
        if(obj instanceof String) {
          cell.setCellValue((String) obj);
        }else if(obj instanceof Integer) {
          cell.setCellValue((Integer) obj);
        }
      }
    }
    
    try {
      FileOutputStream out = new FileOutputStream( new File("haha.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println("luu thanh cong");
    } catch (Exception e) {
      e.printStackTrace();
      // TODO: handle exception
    }
  }
}
