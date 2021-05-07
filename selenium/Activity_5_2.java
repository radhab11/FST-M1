package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The check box input is Selected: " + checkBox.isSelected());
        
        checkBox.click();
        
        System.out.println("The check box input is Selected: " + checkBox.isSelected());
        
        driver.close();

	}

}
