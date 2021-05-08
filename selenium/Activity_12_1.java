package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_12_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.training-support.net/selenium/iframes");

		String pageTitle = driver.getTitle();
		System.out.println("The Title is: " + pageTitle);
		
		driver.switchTo().frame(0);
		
		WebElement frame1Heading = driver.findElement(By.className("content"));
		System.out.print("1st Frame Heading is: " + frame1Heading.getText());
		
		WebElement clickMeBtn1 = driver.findElement(By.cssSelector(".ui.red.button"));
		System.out.println("Frame 1 Button is: " + clickMeBtn1.getText());
		System.out.println("Frame 1 Button color is: " + clickMeBtn1.getCssValue("background-color"));
		clickMeBtn1.click();
		
		System.out.println("After click, Frame 1 Button is: " + clickMeBtn1.getText());
		System.out.println("Frame 1 Button color is: " + clickMeBtn1.getCssValue("background-color"));
		
		driver.switchTo().defaultContent();
		
        driver.switchTo().frame(1);
		
		WebElement frame2Heading = driver.findElement(By.className("content"));
		System.out.print("2nd Frame Heading is: " + frame2Heading.getText());
		
		WebElement clickMeBtn2 = driver.findElement(By.cssSelector(".ui.green.button"));
		System.out.println("Frame 2 Button is: " + clickMeBtn2.getText());
		System.out.println("Frame 2 Button color is: " + clickMeBtn2.getCssValue("background-color"));
		clickMeBtn2.click();
		
		System.out.println("After click, Frame 2 Button is: " + clickMeBtn2.getText());
		System.out.println("Frame 2 Button color is: " + clickMeBtn2.getCssValue("background-color"));
		
		driver.switchTo().defaultContent();
		
		driver.close();	
	}

}
