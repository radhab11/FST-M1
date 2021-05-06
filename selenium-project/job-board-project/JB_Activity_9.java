package selenium_JOBBOARD_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JB_Activity_9 {
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
	public void publishJob() throws InterruptedException {

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

		//Job Listing page 
		WebElement jobListingsBtn = driver.findElement(By.linkText("Job Listings"));
		jobListingsBtn.click();
		Thread.sleep(3000);
		//		boolean jobListSelected = jobListingsBtn.isSelected();
		//		System.out.println("The Job Listings Button is Selected: " + jobListSelected);
		String jobListtitle = driver.getTitle();
		System.out.println("The Title of Job Listings page is: " + jobListtitle);

		//Add New Button
		WebElement addNewBtn = driver.findElement(By.xpath("//a[@class='page-title-action']"));
		addNewBtn.click();
		Thread.sleep(3000);
		String addNewtitle = driver.getTitle();
		System.out.println("The Title of Add New page is: " + addNewtitle);

		WebElement welcomePopup = driver.findElement(By.xpath("//h1[@class='edit-post-welcome-guide__heading']"));
		if(welcomePopup.isDisplayed()) {
			WebElement closeDialogBtn = driver.findElement(By.xpath("//button[@aria-label='Close dialog']"));
			closeDialogBtn.click();
		}
		
		Thread.sleep(2000);

		//Filling the Job Details
		WebElement positionTxt = driver.findElement(By.xpath("//label[@for='post-title-0']"));
		WebElement enterPositionTxt = driver.findElement(By.xpath("//textarea[@class='editor-post-title__input']"));
		Assert.assertEquals("Position", positionTxt.getText());
		enterPositionTxt.click();
		Thread.sleep(1000);
		enterPositionTxt.sendKeys("Radha_Dev Test");
		System.out.println("The "+ positionTxt.getText()+ " is : " + enterPositionTxt.getAttribute("value"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement jobDataTxt = driver.findElement(By.xpath("//h2[@class='hndle ui-sortable-handle']"));
		Assert.assertEquals("Job Data", jobDataTxt.getText());

		WebElement postedByTxt = driver.findElement(By.xpath("//label[@for='_job_author']"));

		if(!postedByTxt.isDisplayed()) {
			WebElement expandBtn = driver.findElement(By.xpath("//button[@class='handlediv']"));
			expandBtn.click();
		}

		WebElement appEmailRUrl = driver.findElement(By.xpath("//label[@for='_application']"));
		WebElement enterEmailRUrl = driver.findElement(By.xpath("//input[@id='_application']"));
		enterEmailRUrl.sendKeys("radhab11@in.ibm.com");
		System.out.println("The "+ appEmailRUrl.getText()+ " is : " + enterEmailRUrl.getAttribute("value"));

		WebElement companyName = driver.findElement(By.xpath("//label[@for='_company_name']"));
		WebElement enterCompanyName = driver.findElement(By.xpath("//input[@id='_company_name']"));
		enterCompanyName.sendKeys("IBM Pvt Ltd");
		System.out.println("The "+companyName.getText() + "is: " + enterCompanyName.getAttribute("value"));

		WebElement companyWebSite = driver.findElement(By.xpath("//label[@for='_company_website']"));
		WebElement enterCompanyWebSite = driver.findElement(By.xpath("//input[@id='_company_name']"));
		enterCompanyWebSite.sendKeys("https://www.ibm.com/");
		System.out.println("The "+ companyWebSite.getText()+" is: " + enterCompanyWebSite.getAttribute("value"));

		WebElement companyTagline = driver.findElement(By.xpath("//label[@for='_company_tagline']"));
		WebElement enterCompanyTagline = driver.findElement(By.xpath("//input[@id='_company_tagline']"));
		enterCompanyTagline.sendKeys("Service Based Company");
		System.out.println("The "+ companyTagline.getText()+" is: " + enterCompanyTagline.getAttribute("value"));

		WebElement companyTwitter = driver.findElement(By.xpath("//label[@for='_company_twitter']"));
		WebElement enterCompanyTwitter = driver.findElement(By.xpath("//input[@id='_company_twitter']"));
		enterCompanyTwitter.sendKeys("twitter@ibm");
		System.out.println("The "+ companyTwitter.getText()+" is: " + enterCompanyTwitter.getAttribute("value"));

		WebElement companyVideo = driver.findElement(By.xpath("//label[@for='_company_video']"));
		WebElement enterCompanyVideo = driver.findElement(By.xpath("//input[@id='_company_video']"));
		enterCompanyVideo.sendKeys("https://www.ibm.com/");
		System.out.println("The "+ companyVideo.getText()+" is: " + enterCompanyVideo.getAttribute("value"));
		WebElement uploadBtn = driver.findElement(By.xpath("//button[@class='button button-small wp_job_manager_upload_file_button']"));
		WebElement viewBtn = driver.findElement(By.xpath("//button[@class='button button-small wp_job_manager_view_file_button']"));
		System.out.println("The Upload Button is Enabled: " + uploadBtn.isEnabled());
		System.out.println("The View Button is Enabled: " + viewBtn.isEnabled());

		WebElement positionFilled = driver.findElement(By.xpath("//label[@for='_filled']"));
		WebElement positionFilledCheckbox = driver.findElement(By.xpath("//input[@id='_filled']"));
		WebElement featuredListing = driver.findElement(By.xpath("//label[@for='_featured']"));
		WebElement featuredListingCheckbox = driver.findElement(By.xpath("//input[@id='_featured']"));
		positionFilledCheckbox.click();
		featuredListingCheckbox.click();
		System.out.println("The Position Filled is : " + positionFilled.getText());
		System.out.println("The Featured Listing is : " + featuredListing.getText());

		WebElement listingExpiryDate = driver.findElement(By.xpath("//label[@for='_job_expires']"));
		WebElement enterListingExpiryDate = driver.findElement(By.xpath("//input[@id='_job_expires']"));
		enterListingExpiryDate.sendKeys("August 3, 2021");
		System.out.println("The "+ listingExpiryDate.getText()+" is: " + enterListingExpiryDate.getAttribute("value"));

		WebElement publishBtn1 = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']"));
		System.out.println("Is publish enabled: " + publishBtn1.isEnabled());
		publishBtn1.click();
		WebElement publishBtn2 = driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary'][1]"));
		System.out.println("Is second publish enabled: " + publishBtn2.isEnabled());
		Actions actions = new Actions(driver);
		actions.moveToElement(publishBtn2).click().perform();
		Thread.sleep(5000);
		
//		driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary'][1]")).click();
		WebElement viewJobsBtn = driver.findElement(By.xpath("//a[@class='components-button is-secondary']"));
		viewJobsBtn.click();
		
		//Verify posted job in Jobs page
		WebElement jobBtn = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']"));
		jobBtn.click();
		String jobBtnTitle = driver.getTitle();
		Thread.sleep(5000);
		System.out.println("The Jobs Title is: " + jobBtnTitle);
				
		System.out.println("The Title of job is: " + driver.findElement(By.xpath("//h3['Radha_Dev Test']")).getText());
		System.out.println("The Date and time of posted job is: " + driver.findElement(By.xpath("//li[@class='date']")).getText());
		Thread.sleep(5000);	

	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}

}
