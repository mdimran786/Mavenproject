package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;

public class Orange_HRM {
	
	WebDriver driver;
  
  @Test(priority = 0)
  public void orange_hrm_services() {
		
  	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.name("Submit")).click();
	  
  }
  
  @Test(priority = 1)
  public void admin() throws Exception {
	 
	  Actions a = new Actions(driver);
	  a.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/b[1]"))).build().perform();
	  Thread.sleep(2000);
	  a.moveToElement(driver.findElement(By.linkText("User Management"))).build().perform();
	  driver.findElement(By.linkText("Users")).click();
	  Thread.sleep(2000);
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	  Thread.sleep(2000);
	  File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(f, new File("C:\\Users\\subhani\\Downloads\\selenium\\TestNG\\screenshots\\.png"));
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	  Thread.sleep(2000);
	  a.moveToElement(driver.findElement(By.linkText("Job"))).build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Job Titles")).click();
	  Thread.sleep(2000);
  
  }
   @Test(priority = 2)
  public void PIM() throws Exception {
	  
	  Actions a = new Actions(driver);
	  a.moveToElement(driver.findElement(By.linkText("PIM"))).build().perform();
	  driver.findElement(By.linkText("Add Employee")).click();
	  Thread.sleep(2000);
	  
  }
  
  @Test(priority = 3)
  public void leave() throws Exception {
	
	  Actions a = new Actions(driver);
	  a.moveToElement(driver.findElement(By.linkText("Leave"))).build().perform();
	  a.moveToElement(driver.findElement(By.linkText("Configure"))).build().perform();
	  driver.findElement(By.linkText("Leave Period")).click();
	  Thread.sleep(2000);

  }  
  
  @Test(priority = 4)
  public void maintenance() throws Exception {
	  
	  Actions a = new Actions(driver);
	  a.moveToElement(driver.findElement(By.linkText("Maintenance"))).build().perform();
	  a.moveToElement(driver.findElement(By.linkText("Purge Records"))).build().perform();
	  driver.findElement(By.linkText("Employee Records")).click();
	  Thread.sleep(2000);
  }
  @BeforeTest
  public void orangehrm_url() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void closing_site() throws Exception {
	  
	  driver.findElement(By.linkText("Welcome Admin")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Logout")).click();
	  driver.quit();
  
  }

}
