package selenium_CRM_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity_5 {
	WebDriver driver;
	@BeforeMethod
	public void accessingcrmsite() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/crm/");
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("The Title is: " + title);
		Assert.assertEquals("SuiteCRM", driver.getTitle());
		}
	@Test(priority = 0)
	public void testLogin() {

		WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
		userName.sendKeys("admin");
		String usernameVal = userName.getAttribute("value");
		System.out.println("The UserName is: " + usernameVal);
		
		WebElement passWord = driver.findElement(By.xpath("//input[@id='username_password']"));
		passWord.sendKeys("pa$$w0rd");
		String passwordText = passWord.getAttribute("value");
		System.out.println("The Password is: " + passwordText);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@title='Log In']"));
		String loginText = loginBtn.getAttribute("value");
		System.out.println("The login btn is: " + loginText);
		loginBtn.click();
	}
	@Test(priority = 1)
	public void tooBarcolor() {
		testLogin();
		WebElement toolBar = driver.findElement(By.xpath("//div[@id='toolbar']"));
		toolBar.isDisplayed();
		String toolbarColor = toolBar.getCssValue("color");
		System.out.println("The color of toolbar is: " + toolbarColor);

	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
