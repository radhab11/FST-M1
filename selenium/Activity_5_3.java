package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("The check box input is Enabled: " + textField.isEnabled());
        
       driver.findElement(By.id("toggleInput")).click();
        
        System.out.println("The check box input is Enabled: " + textField.isEnabled());
        
        driver.close();

	}

}
