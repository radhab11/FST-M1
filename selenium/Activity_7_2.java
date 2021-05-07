package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_7_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-attributes");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        userName.sendKeys("Radha");
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        password.sendKeys("password");
        
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
        confirmPassword.sendKeys("password");
        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));
        email.sendKeys("radhab11@in.ibm.com");
        
        WebElement signUpBtn = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));
        signUpBtn.click();
        
        WebElement loginMsg = driver.findElement(By.id("action-confirmation"));
     
        System.out.println("The Welcome Message is : " + loginMsg.getText());
        
        driver.close();

	}

}
