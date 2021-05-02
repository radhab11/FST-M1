package selenium_CRM_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity_2 {
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
	@Test
	public void urlOfHeader() {

		WebElement headerText = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		String headerURL = headerText.getAttribute("src");
		System.out.println("The URL of Header is: " + headerURL);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
