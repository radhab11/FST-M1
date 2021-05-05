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

public class CRM_Activity_8 {
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
		WebElement accountsTab = driver.findElement(By.xpath("//a[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DAccounts%26action%3Dindex%26parentTab%3DSales']"));
		accountsTab.click();
		Thread.sleep(10000);
		System.out.println("The Accounts Title is: " + driver.getTitle());	
		List<WebElement> nameColumn = driver.findElements(By.xpath("//table[contains(@class, 'list view')]/tbody/tr/td[3]"));
		for(int i=0; i<nameColumn.size(); i+=2) {
			String nameTxt = nameColumn.get(i).getText();
			if(i<=9) {
				/*	The table row values are 
				5D Investments, 
				5D Investments, 
				AB Drivers Limited,
				B.C.Investng International, 
				B.H. Edwards Inc*/
			System.out.println("The first 5-Odd numbered Names are: " + nameTxt);
			
			}
		}
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
