package testng;

import org.testng.annotations.Test;

public class Grouping {
  @Test(groups = "fb")
  public void facebook() {
	  System.out.println("enter valid url for facebook application");
  }
  
  @Test(groups = "Gmail")
  public void gmail() {
	  System.out.println("enter valid url for gmail application");
  }
  
  @Test(groups = "ohrms")
  public void ohrm() {
	  System.out.println("enter valid url for orangehrm application");
  }
  
  @Test(groups = "fb")
  public void facebookurl() {
	  System.out.println("www.facebook.com");
  }
  
  @Test(groups = "Gmail")
  public void gmailurl() {
	  System.out.println("www.gmail.com");
  }
  
  @Test(groups = "ohrms")
  public void ohrmurl() {
	  System.out.println("www.opensource-demo.orangehrmlive.com");
  }
  
}
