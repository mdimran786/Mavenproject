package selenium_mavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Sample_excel_Test {
@Test
  public void excel() throws IOException {
	  FileInputStream fis = new FileInputStream("C:\\Users\\subhani\\Downloads\\selenium\\MavenProject\\Database\\Test.xlsx");
	  XSSFWorkbook w = new XSSFWorkbook(fis);
	  //XSSFSheet sheet = workbook.getSheet("Test");
	  XSSFSheet sheet = w.getSheetAt(0);
	  for (int i = 0; i<=sheet.getLastRowNum(); i++) {
		  System.out.println(sheet.getRow(i).getCell(1).getStringCellValue());
		  System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
	  }
  }
  
  @Test
  public void new_excel() throws IOException {
	  String filepath = System.getProperty("user.dir")+"\\Database\\Test.xlsx";
	  String sheetname = "Test";
	  File f = new File(filepath);
	  FileInputStream fis = new FileInputStream(f);
	  Workbook book = null;
	  Sheet she = null;
	  Row ro = null;
	  Cell c = null;
	  if (filepath.endsWith(".xls"))
		 book = new HSSFWorkbook(fis);
		 else if (filepath.endsWith(".xlsx"))
			 book = new XSSFWorkbook(fis);
	  she = book.getSheet("Test");
	  System.out.println(she.getLastRowNum());
	  ro = she.getRow(1);
	  c = ro.getCell(0);
	  System.out.println(c.getStringCellValue());
  }
}
