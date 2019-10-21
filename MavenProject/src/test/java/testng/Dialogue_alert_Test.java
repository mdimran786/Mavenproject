package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
public class Dialogue_alert_Test {
	WebDriver driver;
	public void screenshot(String str) throws IOException {
		DateFormat df = new SimpleDateFormat("yyyy-MMM-dd-hh-mm-ss");
		Date d = new Date();
		String time = df.format(d);
		System.out.println("time");
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("C:\\Users\\subhani\\Downloads\\selenium\\TestNG\\screenshots\\"+str+time+".jpeg"));
	}
  @Test
  public void f() throws Exception {
	  driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	  System.out.println(driver.switchTo().alert().getText());
	 // screenshot("alert");
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);  
	  screenshot("accept");
  }
  @BeforeTest
  public void beforetest() throws IOException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.manage().window().maximize();
	  screenshot("url");
  }
  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }
}
