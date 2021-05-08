package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_12_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.training-support.net/selenium/nested-iframes");

		String pageTitle = driver.getTitle();
		System.out.println("The Title is: " + pageTitle);
		
		driver.switchTo().frame(0);
		
		driver.switchTo().frame(0);
		
		WebElement frame1Heading = driver.findElement(By.className("content"));
		System.out.print("1st Frame Heading is: " + frame1Heading.getText());
		
		driver.switchTo().defaultContent();
	    
		driver.switchTo().frame(0);
		
		driver.switchTo().frame(1);
		
		WebElement frame2Heading = driver.findElement(By.className("content"));
		System.out.print("1st Frame Heading is: " + frame2Heading.getText());

		driver.close();
	}

}
