package testNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_1 {
	WebDriver driver;
  @BeforeMethod
  public void accessingUrl() {
	  System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
      driver = new FirefoxDriver();
      driver.get("https://www.training-support.net");
  }
  
  @Test
  public void newPage() {
	  System.out.println("The Title Is:" + driver.getTitle());
	  Assert.assertEquals("Training Support", driver.getTitle());
	  
	  WebElement aboutUsBtn = driver.findElement(By.id("about-link"));
      System.out.println("The Text in element Is:" + aboutUsBtn.getText());
      aboutUsBtn.click();
      Assert.assertEquals("About Training Support", driver.getTitle());   
  }
  
  @AfterMethod
  public void closeApp() {
      driver.close();
  }
}
