package selenium_mavenProject;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataproviderTest {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void data(String sUsername, String sPassword) throws InterruptedException {
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("email")).sendKeys(sUsername);
	  driver.findElement(By.name("pass")).clear();
	  driver.findElement(By.name("pass")).sendKeys(sPassword);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@value='Log In'and@type='submit']")).click();
  }
  
  @Test
  public void quit() {
	  driver.manage().deleteAllCookies();
	  driver.quit();
  }
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      { "Ragulutundi", "Mogalipodha" },
      { "UnnattundiGunde", "VandaKottukunde" },
      { "RaammaChilakamma", "PremaMolakamma" },
      { "NeeliNingilo", "NinduJabili" },
      { "BhajanaChese", "VidhamuTelapandi" },
      { "KajrareKajrare", "TereKaaleKaaleNaina" }
    };
  }
  
  @BeforeTest
  public void facebookbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\subhani\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http:\\www.facebook.com");	
		driver.manage().window().maximize();
	  
  }
}
