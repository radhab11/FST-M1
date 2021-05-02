package selenium_JOBBOARD_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JB_Activity_8 {
	WebDriver driver;
	
	@BeforeMethod
	public void accessingcrmsite() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/wp-admin/");
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("The Title of Login page is: " + title);
		Assert.assertEquals("Log In ‹ Alchemy Jobs — WordPress", driver.getTitle());
		}
	@Test
	public void testLogin() {

		WebElement userName = driver.findElement(By.xpath("//input[@id='user_login']"));
		userName.sendKeys("root");
		String usernameVal = userName.getAttribute("value");
		System.out.println("The UserName is: " + usernameVal);
		
		WebElement passWord = driver.findElement(By.xpath("//input[@id='user_pass']"));
		passWord.sendKeys("pa$$w0rd");
		String passwordText = passWord.getAttribute("value");
		System.out.println("The Password is: " + passwordText);
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
		String loginText = loginBtn.getAttribute("value");
		System.out.println("The login btn is: " + loginText);
		loginBtn.click();
		
		WebElement dashboardBtn = driver.findElement(By.linkText("Dashboard"));
		dashboardBtn.isDisplayed();
		System.out.println("The Dashboard Text btn is: " + dashboardBtn.getText());
		String title = driver.getTitle();
		System.out.println("The Title of Dashboard is: " + title);
		Assert.assertEquals("Dashboard ‹ Alchemy Jobs — WordPress", driver.getTitle());
	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
}

