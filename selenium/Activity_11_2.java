package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		String pageTitle = driver.getTitle();
		System.out.println("The Title is: " + pageTitle);
		
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		Alert confirmAlertPopUp = driver.switchTo().alert();
		System.out.println("The Text in the Alert is: " + confirmAlertPopUp.getText());
		
		confirmAlertPopUp.accept();
		confirmBtn.click();
		confirmAlertPopUp.dismiss();
		driver.close();
	}

}
