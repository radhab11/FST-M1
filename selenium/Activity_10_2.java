package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity_10_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		String pressedKeyTxt;

		driver.get(" https://www.training-support.net/selenium/input-events");

		String pageTitle = driver.getTitle();
		System.out.println("The Title is: " + pageTitle);
		
		WebElement pressedKey = driver.findElement(By.id("keyPressed"));
		Action actionSequence1 = actions.sendKeys("R").build();
		actionSequence1.perform();
		pressedKeyTxt = pressedKey.getText();
		System.out.println("Pressed Key is: " + pressedKeyTxt);
		
		Action actionSequence2 = actions
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.sendKeys("c")
				.keyUp(Keys.CONTROL)
				.build();
		actionSequence2.perform();
		System.out.println("Pressed Key is: " + pressedKeyTxt);
		
		driver.close();	
	}

}
