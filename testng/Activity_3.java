package testNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_3 {
	WebDriver driver;
	  @BeforeClass
	  public void accessingUrl() {
		  System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
	      driver = new FirefoxDriver();
	      driver.get("https://www.training-support.net/selenium/login-form");
	      System.out.println("The Title Is:" + driver.getTitle());
		  Assert.assertEquals("Login Form", driver.getTitle()); 
	  }
	  
	  @Test
	  public void login() {
		 WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		 WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		 userName.sendKeys("admin");
		 System.out.println("The Username is: " + userName.getAttribute("value"));
		 password.sendKeys("password");
		 System.out.println("The Password is: " + password.getAttribute("value"));

		 WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		 loginBtn.click();
		 
		 WebElement confirmMsg = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		 System.out.println("The Confirmation Message is: " + confirmMsg.getText());
		 Assert.assertEquals("Welcome Back, admin", confirmMsg.getText()); 
		
	  }
	  
	  @AfterClass
	  public void closeApp() {
	      driver.close();
	  }
}
