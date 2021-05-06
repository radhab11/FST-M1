package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
        driver.get("https://www.training-support.net/selenium/simple-form");

        System.out.println("The Title is: " +driver.getTitle());

        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));

        firstName.sendKeys("Radha");
        lastName.sendKeys("B");

        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("radha@example.com");

        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("9999999999");

        driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");

        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

	}

}
