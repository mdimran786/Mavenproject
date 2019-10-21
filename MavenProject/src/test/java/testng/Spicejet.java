package testng;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Spicejet {
	WebDriver driver;

  @Test
  public void Spice_jet() throws Exception {
	  Actions a = new Actions(driver);
	  a.moveToElement(driver.findElement(By.linkText("ADD-ONS"))).build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("International Connection Baggage")).click();
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	  Thread.sleep(2000);
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	  Thread.sleep(2000);
  }
  @BeforeTest
  public void spicejet_url() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://www.spicejet.com");
	  driver.manage().window().maximize();
	  
  }
  @AfterTest
  public void closing() {
	  driver.quit();
  }
}
