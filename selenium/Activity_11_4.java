package SeleniumActivities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_11_4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,5);

		driver.get("https://www.training-support.net/selenium/tab-opener");

		String pageTitle = driver.getTitle();
		System.out.println("The Title is: " + pageTitle);
		
		String baseWindow = driver.getWindowHandle();
		System.out.println("The Base Window is; " + baseWindow);
		
		WebElement clickMeBtn = driver.findElement(By.id("launcher"));
		clickMeBtn.click();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("The all Windows are; " + allWindowHandles);
		
		for(String handle: allWindowHandles) {
			driver.switchTo().window(handle);
		}
		
		System.out.println("The current Window handle; " + driver.getWindowHandle());
		wait.until(ExpectedConditions.titleIs("Newtab"));
		
		System.out.println("New Tab Title is: " + driver.getTitle());
		
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='actionButton']"))));
		Thread.sleep(3000);

        String newTabText = driver.findElement(By.xpath("//div[@class='sub header']")).getText();
	
        System.out.println("New tab heading is: " + newTabText);

        driver.findElement(By.linkText("Open Another One!")).click();
	
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	
        allWindowHandles = driver.getWindowHandles();
	
        System.out.println("All window handles: " + allWindowHandles);
	
        for (String handle : driver.getWindowHandles()) {
	
            driver.switchTo().window(handle);
	
        }
	
        System.out.println("New tab handle: " + driver.getWindowHandle());
	
        wait.until(ExpectedConditions.titleIs("Newtab2"));
	
        System.out.println("2nd New Tab Title is: " + driver.getTitle());
        Thread.sleep(2000);
	
        newTabText = driver.findElement(By.cssSelector("div.content")).getText();
	
        System.out.println("2nd New tab heading is: " + newTabText);
        
        driver.quit();

	}

}
