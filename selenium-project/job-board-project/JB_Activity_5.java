package selenium_JOBBOARD_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JB_Activity_5 {
	WebDriver driver;
	@BeforeMethod
	public void accessingJBsite() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("https://alchemy.hguy.co/jobs/");
		Thread.sleep(5000);
	}
	
	@Test(priority=0)
	public void title() {
		
		String title = driver.getTitle();
		System.out.println("The Title is: " + title);
		Assert.assertEquals("Alchemy Jobs – Job Board Application", driver.getTitle());
	}
	@Test(priority=1)
	public void jobsBtn() throws InterruptedException {

		WebElement jobBtn = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']"));
		jobBtn.click();
		String jobBtnTitle = driver.getTitle();
		Thread.sleep(5000);
		System.out.println("The Jobs Title is: " + jobBtnTitle);
		
		WebElement searchJobsTxt = driver.findElement(By.linkText("Jobs"));
		System.out.println("The Jobs Header is: " + searchJobsTxt.getText());
		Assert.assertEquals("Jobs", searchJobsTxt.getText());
	}
	
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
