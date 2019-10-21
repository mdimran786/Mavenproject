package selenium_mavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingDataInExistingSheet {
	
  @Test
  public void Existing_sheet() throws IOException {
	
	  String Filepath = System.getProperty("user.dir")+"\\Database\\Test.xlsx";
	  String sheetname = "Test";
	  //Comment a, b;
	  File f = new File(Filepath);
	  FileInputStream fis = new FileInputStream(Filepath);
	  Workbook wb = null;
	  Sheet sheet = null;
	  Row row = null;
	  Cell cell = null;
	  
	  if (Filepath.endsWith(".xls"))
			 wb = new HSSFWorkbook(fis);
			 else if (Filepath.endsWith(".xlsx"))
				 wb = new XSSFWorkbook(fis);
	  sheet = wb.getSheet("Test");
	  
	  int nr = sheet.getLastRowNum()+1;
	  for (int i=0; i<nr; i++) {
		  row = sheet.getRow(i);
		  cell = row.getCell(0);
			  cell = row.createCell(0);
			  //a = cell.getCellComment();
			  //System.out.println(a);
			  cell.setCellValue("entered");
			  for (int j=0; j<nr; j++) {
				  row = sheet.getRow(j);
				  cell = row.getCell(1);
					  cell = row.createCell(1);
				  	  //b = cell.getCellComment();
				  	  //System.out.println(b);
				  	  cell.setCellValue("located");

			  }
	  }
	  FileOutputStream fos = new FileOutputStream(f);
	  wb.write(fos);
	  wb.close();
  }
}
