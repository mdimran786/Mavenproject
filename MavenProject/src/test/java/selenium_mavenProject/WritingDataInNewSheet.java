package selenium_mavenProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingDataInNewSheet {
  @Test
  public void New_Worksheet() throws IOException {
	  String Filepath = System.getProperty("user.dir")+"\\Database\\Test2.xlsx";
	  File f = new File(Filepath);
	  Workbook wb = null;
	  Sheet sheet = null;
	  Row r = null;
	  Cell c = null;
	  if (Filepath.endsWith(".xls"))
			 wb = new HSSFWorkbook();
			 else if (Filepath.endsWith(".xlsx"))
				 wb = new XSSFWorkbook();
		sheet = wb.createSheet("TestSheet1");
		for (int i=0; i<10; i++) {
			r = sheet.createRow(i);
			for (int j= 0; j<10; j++) {
				c = r.createCell(j);
				c.setCellValue("Test2"+i+j);
			}
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	  
  }
}
