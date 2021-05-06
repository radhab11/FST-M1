package selenium_CRM_Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity_7 {
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
	public void testLogin() throws InterruptedException {

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
		Thread.sleep(5000);

		WebElement toolBar = driver.findElement(By.xpath("//div[@id='toolbar']"));
		toolBar.isDisplayed();
	}
	@Test(priority =1)
	public void salesLeadsTab() throws InterruptedException {
		testLogin();
		WebElement salesTab = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
		String salesText = salesTab.getText();
		System.out.println("Sales text is: " + salesText);
		boolean salesTxtPresent = salesTab.isDisplayed();
		System.out.println("Sales text is present: " + salesTxtPresent);

		salesTab.click();
		WebElement leadsTab = driver.findElement(By.xpath("//a[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Dindex%26parentTab%3DSales']"));
		leadsTab.click();
		Thread.sleep(10000);
		WebElement infoTab = driver.findElement(By.xpath("//span[@id='adspan_e3b6f9f3-b87c-2486-fa8c-6061ba037e94']/span"));
		infoTab.click();
		Thread.sleep(5000);	   
		String mobileNumber = driver.findElement(By.xpath("//span[@class='phone']")).getText();
		System.out.println("The Mobile number is: " + mobileNumber);

	}

	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
