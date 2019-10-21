package selenium_mavenProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NaukriData {
	WebDriver driver;
  @Test
  public void login() throws IOException, InterruptedException {
	  FileInputStream fis = new FileInputStream("C:\\Users\\subhani\\Downloads\\selenium\\MavenProject\\Database\\Test1.xlsx");
	  XSSFWorkbook work = new XSSFWorkbook(fis);
	  XSSFSheet she = work.getSheet("TestSheet");
	  for (int i = 0; i<she.getLastRowNum(); i++) {
		  driver.findElement(By.xpath(".//*[@id='login_Layer']")).click();
			driver.findElement(By.name("email")).sendKeys((she.getRow(i).getCell(0).getStringCellValue()));
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='pLogin']")).sendKeys((she.getRow(i).getCell(1).getStringCellValue()));
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.get("http:\\www.naukri.com");
			Thread.sleep(2000);
		
	  }
  }
  
  @BeforeTest
  public void browsing() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http:\\www.naukri.com");
  }
}
