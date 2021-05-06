package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println("The Title Is:" + driver.getTitle());
        
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys("Radha");
        lastName.sendKeys("B");
        
        driver.findElement(By.id("email")).sendKeys("radha@gmail.com");
        driver.findElement(By.id("number")).sendKeys("999999999");
        
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        
        driver.close();
       

	}

}
