package selenium_JOBBOARD_Proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JB_Activity_1 {
	WebDriver driver;
	@BeforeMethod
	public void accessingJBsite() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
		Thread.sleep(5000);
	}
	
	@Test
	public void title() {
		
		String title = driver.getTitle();
		System.out.println("The Title is: " + title);
		Assert.assertEquals("Alchemy Jobs – Job Board Application", driver.getTitle());
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}	
}
