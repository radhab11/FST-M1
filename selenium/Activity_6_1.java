package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://training-support.net/selenium/dynamic-controls");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement toggleBtn = driver.findElement(By.id("toggleCheckbox"));
        toggleBtn.click();
        
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
        System.out.println("The check box input is displayed: " + checkBox.isDisplayed());
        
        toggleBtn.click();
        
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        System.out.println("The check box input is displayed: " + checkBox.isDisplayed());
        
        driver.close();

	}

}
