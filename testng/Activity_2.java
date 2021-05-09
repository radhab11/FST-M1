package testNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_2 {
	WebDriver driver;
	  @BeforeClass
	  public void accessingUrl() {
		  System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
	      driver = new FirefoxDriver();
	      driver.get("https://www.training-support.net/selenium/target-practice");
	  }
	  
	  @Test
	  public void test1() {
		  System.out.println("The Title Is:" + driver.getTitle());
		  Assert.assertEquals("Target Practice", driver.getTitle()); 
	  }
	  
	  @Test
	  public void test2() {
		  WebElement blackBtn = driver.findElement(By.cssSelector(".ui.black.button"));
	      Assert.assertEquals("black", blackBtn.getText());   
	  }
	  @Test(enabled = false)
	  public void test3() {
		  
		  WebElement subHeading = driver.findElement(By.className("sub header"));
	      System.out.println("The Sub Heading Is:" + subHeading.getText()); 
	  }
	  @Test
	  public void test4() {
		  throw new SkipException("Test case Skipped "); 
	  }
	  
	  @AfterClass
	  public void closeApp() {
	      driver.close();
	  }
}
