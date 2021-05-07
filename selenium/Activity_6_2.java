package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://training-support.net/selenium/ajax");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement changeContentBtn = driver.findElement(By.xpath("//button[@class='ui violet button']"));
        changeContentBtn.click();
        
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
        
        WebElement helloTxt = driver.findElement(By.id("ajax-content"));
        System.out.println(helloTxt.getText());
        
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        
        WebElement iamLateTxt = driver.findElement(By.id("ajax-content"));
        System.out.println(iamLateTxt.getText());
        
        driver.close();

	}

}
