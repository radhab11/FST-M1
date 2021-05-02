package selenium_JOBBOARD_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JB_Activity_6 {
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
	public void searchJobs() throws InterruptedException {

		WebElement jobBtn = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']"));
		jobBtn.click();
		String jobBtnTitle = driver.getTitle();
		Thread.sleep(5000);
		System.out.println("The Jobs Title is: " + jobBtnTitle);
		
		WebElement searchJobsTxt = driver.findElement(By.linkText("Jobs"));
		System.out.println("The Jobs Header is: " + searchJobsTxt.getText());
		Assert.assertEquals("Jobs", searchJobsTxt.getText());
		
		WebElement searchKeyword = driver.findElement(By.xpath("//input[@id='search_keywords']"));
		searchKeyword.click();
		searchKeyword.sendKeys("Banking");
		System.out.println("The Entered Job type is: " + searchKeyword.getAttribute("value"));
		WebElement searchJobsBtn = driver.findElement(By.xpath("//input[@value='Search Jobs']"));
		searchJobsBtn.click();
		Thread.sleep(5000);
		
		WebElement searchResult = driver.findElement(By.xpath("//div[@class='position']"));
		searchResult.click();
		Thread.sleep(5000);

		WebElement nextBtn = driver.findElement(By.xpath("//a[@rel='next']"));
		if(driver.findElement(By.xpath("//div[@class='job-manager-info']")).isDisplayed()) {
			nextBtn.click();
			Thread.sleep(10000);
			if(driver.findElement(By.xpath("//input[@value='Apply for job']")).isDisplayed()) {
			WebElement applyJobsBtn = driver.findElement(By.xpath("//input[@value='Apply for job']"));
			applyJobsBtn.click();
			Thread.sleep(5000);
			WebElement emailId = driver.findElement(By.xpath("//a[@class='job_application_email']"));
			System.out.println("The Email Id is: " + emailId.getText());
			}
			else {
				nextBtn.click();
			}
		}
		else {
				WebElement applyJobsBtn = driver.findElement(By.xpath("//input[@value='Apply for job']"));
				applyJobsBtn.click();
				Thread.sleep(5000);
				WebElement emailId = driver.findElement(By.xpath("//a[@class='job_application_email']"));
				System.out.println("The Email Id is: " + emailId.getText());
			}	
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
