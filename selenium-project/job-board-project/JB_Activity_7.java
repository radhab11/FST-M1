package selenium_JOBBOARD_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JB_Activity_7 {
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
	public void postJob() throws InterruptedException {
		
		WebElement postJobBtn = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']"));
		postJobBtn.click();
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println("The Title is: " + title);
		Assert.assertEquals("Post a Job – Alchemy Jobs", title);
		
		WebElement postJobTxt = driver.findElement(By.linkText("Post a Job"));
		System.out.println("The Post a Job title is: " + postJobTxt.getText());
		Assert.assertEquals("Post a Job", postJobTxt.getText());
		
		//Filling Details your email
		WebElement yourEmail = driver.findElement(By.xpath("//label[@for='create_account_email']"));
		WebElement enterEmail = driver.findElement(By.xpath("//input[@name='create_account_email']"));
		Assert.assertEquals("Your email", yourEmail.getText());
		enterEmail.sendKeys("radha02@gmail.com");
		System.out.println("Entered email is : " + enterEmail.getAttribute("value"));
		
		//Filling Details Job Title
		WebElement jobTitle = driver.findElement(By.xpath("//label[@for='job_title']"));
		WebElement enterJobTitle = driver.findElement(By.xpath("//input[@name='job_title']"));
		Assert.assertEquals("Job Title", jobTitle.getText());
		enterJobTitle.sendKeys("DevTest");
		System.out.println("Entered Job Title is : " + enterJobTitle.getAttribute("value"));
		
		
		//Filling Details Job type from drop down
		WebElement jobType = driver.findElement(By.xpath("//label[@for='job_type']"));
		WebElement jobDropDown = driver.findElement(By.xpath("//select[@id='job_type']"));
		Assert.assertEquals("Job type", jobType.getText());
		
		Select jobDropDownSelect = new Select(jobDropDown);
		jobDropDownSelect.selectByIndex(0);
	
		//Filling Description
		WebElement jobDescription = driver.findElement(By.xpath("//label[@for='job_description']"));
		WebElement enterJobDescription = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
		Assert.assertEquals("Description", jobDescription.getText());
		enterJobDescription.sendKeys("I am working in IBM as Developer&Tester for iOS Mobile applications");
		System.out.println("Entered Job Description is : " + enterJobDescription.getAttribute("value"));
		
		//Filling Details Application email/URL
		WebElement applicationEmail = driver.findElement(By.xpath("//label[@for='application']"));
		WebElement enterAppEmail = driver.findElement(By.xpath("//input[@name='application']"));
		Assert.assertEquals("Application email/URL", applicationEmail.getText());
		enterAppEmail.sendKeys("Radha01@gmail.com");
		System.out.println("Entered Application Email/URL is : " + enterAppEmail.getAttribute("value"));
		
		
		//Filling Company Details
		WebElement companyDetailsTxt = driver.findElement(By.xpath("//h2['Company Details']"));
		System.out.println("The Comapny Details Tiltle is: " + companyDetailsTxt.getText());
		Assert.assertEquals("Company Details", companyDetailsTxt.getText());
		
		//Filling Company Name
		WebElement companyName = driver.findElement(By.xpath("//label[@for='company_name']"));
		WebElement enterCompanyName = driver.findElement(By.xpath("//input[@name='company_name']"));
		Assert.assertEquals("Company name", companyName.getText());
		enterCompanyName.sendKeys("IBM India Private Limited");
		System.out.println("Entered Company Name is : " + enterCompanyName.getAttribute("value"));
		
		//Selecting Preview button
		WebElement previewBtn = driver.findElement(By.xpath("//input[@value='Preview']"));
		previewBtn.click(); 
		
		//Preview Page verification
		WebElement previewTxt = driver.findElement(By.xpath("//h2['Preview']"));
		WebElement submitBtn = driver.findElement(By.xpath("//input[@id='job_preview_submit_button']"));
		Assert.assertEquals("Preview", previewTxt.getText());
		submitBtn.click();
		
		//Verify successful entry of Job
		WebElement successText = driver.findElement(By.xpath("//div[@class='entry-content clear']"));
		System.out.println(successText.getText());
		
		//Verify psted job in Jobs page
		WebElement jobBtn = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']"));
		jobBtn.click();
		String jobBtnTitle = driver.getTitle();
		Thread.sleep(5000);
		System.out.println("The Jobs Title is: " + jobBtnTitle);
		
		System.out.println("The Title of job is: " + driver.findElement(By.xpath("//h3['Dev Test']")).getText());
		System.out.println("The Title of Company is: " + driver.findElement(By.xpath("//strong['IBM India Private Limited']")).getText());
		System.out.println("The JobType is: " + driver.findElement(By.xpath("//li[@class='job-type freelance']")).getText());
		System.out.println("The Date and time of posted job is: " + driver.findElement(By.xpath("//li[@class='date']")).getText());
		Thread.sleep(5000);	
		
	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
