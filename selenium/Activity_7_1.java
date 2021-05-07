package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_7_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
       

        driver.get("https://training-support.net/selenium/dynamic-attributes");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[starts-with(@class, 'password')]"));
        password.sendKeys("password");
        
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        loginBtn.click();
        
        WebElement welcomeMsg = driver.findElement(By.id("action-confirmation"));
     
        System.out.println("The Welcome Message is : " + welcomeMsg.getText());
        
        driver.close();

	}

}
