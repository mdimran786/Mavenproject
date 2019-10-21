package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SampleTest {
  @Test(priority = 0)
  public void a() {
	  System.out.println("a valid");
  }
  @Test(priority = 2)
  public void c() {
	  System.out.println("and correct");
  }
  @Test(priority = 1)
  public void b() {
	  System.out.println("and absolute");
  }
  @BeforeTest
  public void d() {
	  System.out.println("Enter");
  }

  @AfterTest
  public void e() {
	  System.out.println("number");
  }

}
