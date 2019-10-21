package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Onlinesbi {
	WebDriver driver;
  @Test(priority = 0)
  public void currentaccount() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.onlinesbi.com");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  Actions a = new Actions(driver);
	  Thread.sleep(2000);
	  a.moveToElement(driver.findElement(By.linkText("Apply for SB/ Current Account"))).build().perform();
	  driver.findElement(By.linkText("Apply for SB/ Current Account")).click();
	 
  }
  @Test(priority = 1)
  public void savingaccount() throws Exception {
	  Actions a = new Actions(driver);
	  Thread.sleep(2000);
	  a.moveToElement(driver.findElement(By.linkText("Savings Bank Account"))).build().perform();
	  //driver.findElement(By.linkText("Savings Bank Account")).click();
	  Thread.sleep(2000);
	  
  }
	  
  @Test(priority = 2)
  public void residentindividuals() throws Exception {
	  Actions a = new Actions(driver);
	  Thread.sleep(2000);
	  a.moveToElement(driver.findElement(By.linkText("for Resident Individuals"))).build().perform();
	  Thread.sleep(2000);
	  //driver.findElement(By.linkText("for Resident Individuals")).click();
	  //Thread.sleep(2000);

  }
  
  @Test(priority = 3)
  public void salaryaccount() throws Exception {
	 // Actions a = new Actions(driver);
	//  a.moveToElement(driver.findElement(By.linkText("Salary Account"))).build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Salary Account")).click();
  }
}
