package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PracticeTest {
	WebDriver driver;
  @Test
  public void browsing() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.onlinesbi.com");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  Actions i = new Actions(driver);
	  Thread.sleep(2000);
	  //i.moveToElement(driver.findElement(By.linkText("Apply for SB/ Current Account"))).build().perform();
	  driver.findElement(By.linkText("Apply for SB/ Current Account")).click();
	  Thread.sleep(2000);
	 // i.moveToElement(driver.findElement(By.linkText("Savings Bank Account"))).build().perform();
	  //i.moveToElement(driver.findElement(By.linkText("Savings Bank Account"))).build().perform();
	  driver.findElement(By.linkText("Savings Bank Account")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("for Resident Individuals")).click();
	  //i.moveToElement(driver.findElement(By.linkText("for Resident Individuals"))).build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Salary Account")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(2000);
	  driver.quit();
  }
}
