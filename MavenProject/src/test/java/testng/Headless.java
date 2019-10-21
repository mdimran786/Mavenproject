package testng;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
public class Headless {
	WebDriver driver;
	public void screenshots(String str) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Date d = new Date();
		String time = df.format(d);
		System.out.println(time);
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File("C:\\Users\\subhani\\Downloads\\selenium\\TestNG\\screenshots\\"+str+time+".png"));
	}
	
  @Test
  public void headles() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("headless");
	  driver = new ChromeDriver(options);
	  driver.get("http:\\www.rguktn.ac.in");
	  driver.manage().window().maximize();
	  screenshots("browsing");
	  String str = driver.getCurrentUrl();
	  System.out.println(str);
	  System.out.println(driver.getTitle());
	  Thread.sleep(2000);
	  Actions a = new Actions(driver);
	  a.moveToElement(driver.findElement(By.xpath("//a[@title='Students']"))).build().perform();
	  screenshots("students");
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Education at RGUKT")).click();
	  screenshots("education");
	  Thread.sleep(2000);
	  System.out.println(driver.getCurrentUrl());
	  System.out.println(driver.getTitle());
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	  Thread.sleep(2000);
	  screenshots("scrollingdown");
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@title='Home']")).click();
	  screenshots("home");
	  Thread.sleep(2000);
	  System.out.println(driver.getTitle());
	  System.out.println(driver.getCurrentUrl());
	  Thread.sleep(2000);
	  driver.manage().deleteAllCookies();
	  driver.quit();
	  
  }
}
