package selenium_CRM_Proj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity_9 {
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

		WebElement toolBar = driver.findElement(By.xpath("//div[@id='toolbar']"));
		toolBar.isDisplayed();
	}
	@Test(priority =1)
	public void salesAccountsTab() throws InterruptedException {
		testLogin();
		WebElement salesTab = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
		String salesText = salesTab.getText();
		System.out.println("Sales text is: " + salesText);
		boolean salesTxtPresent = salesTab.isDisplayed();
		System.out.println("Sales text is present: " + salesTxtPresent);

		salesTab.click();
		WebElement leadsTab = driver.findElement(By.xpath("//a[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Dindex%26parentTab%3DSales']"));
		leadsTab.click();
		Thread.sleep(5000);
		System.out.println("The Leads Title is: " + driver.getTitle());	
		System.out.println("The first 10 Names are: " );
		List<WebElement> nameColumn = driver.findElements(By.xpath("//table[contains(@class, 'list view')]/tbody/tr/td[3]"));
		for(int i=0; i<nameColumn.size(); i++) {
			String nameTxt = nameColumn.get(i).getText();
			if(i<=9) {
				System.out.println(nameTxt);

			}
		}

		System.out.println("The first 10 user are: ");
		List<WebElement> userColumn = driver.findElements(By.xpath("//table[contains(@class, 'list view')]/tbody/tr/td[8]"));
		for(int i=0; i<userColumn.size(); i++) {
			String userTxt = userColumn.get(i).getText();
			if(i<=9) {
				System.out.println(userTxt);

			}
		}
	}

	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
