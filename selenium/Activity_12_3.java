package SeleniumActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_12_3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions builder = new Actions(driver);

		driver.get("https://www.training-support.net/selenium/popups");

		String pageTitle = driver.getTitle();
		System.out.println("The Title is: " + pageTitle);
		
		WebElement tooltipMsg = driver.findElement(By.className("content"));
		WebElement signInBtn = driver.findElement(By.xpath("//button[@class='ui huge inverted orange button']"));
		
        builder.moveToElement(signInBtn).pause(Duration.ofSeconds(1)).build().perform();
	
        System.out.println("Tooltip text: " + tooltipMsg.getText());

        signInBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

        driver.findElement(By.id("username")).sendKeys("admin");
	
        driver.findElement(By.id("password")).sendKeys("password");
	
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String message = driver.findElement(By.id("action-confirmation")).getText();
	
        System.out.println(message);

        driver.close();
	}

}
