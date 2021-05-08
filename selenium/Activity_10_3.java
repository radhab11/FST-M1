package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity_10_3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/selenium/drag-drop");

		String pageTitle = driver.getTitle();
		System.out.println("The Title is: " + pageTitle);
		
		WebElement ball = driver.findElement(By.id("draggable"));
		WebElement drapZone1 = driver.findElement(By.id("droppable"));
		WebElement drapZone2 = driver.findElement(By.id("dropzone2"));
		
		Actions dragNDrop = new Actions(driver);
		dragNDrop.dragAndDrop(ball, drapZone1).build().perform();
		System.out.println("Entered DropZone 1");
		
		dragNDrop.dragAndDrop(ball, drapZone2).build().perform();
		System.out.println("Entered DropZone 2");
		
		driver.close();
	}

}
