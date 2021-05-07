package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_9_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement selectedValue = driver.findElement(By.id("single-value"));
        WebElement selectValue = driver.findElement(By.id("single-select"));
        Select dropDown = new Select(selectValue);
        
        dropDown.selectByVisibleText("Option 2");
        System.out.println("The Selected value is: " + selectedValue.getText());
        dropDown.selectByIndex(3);
        System.out.println("The Selected value is: " + selectedValue.getText());
        dropDown.selectByValue("4");
        System.out.println("The Selected value is: " + selectedValue.getText());
        
        List<WebElement> options = dropDown.getOptions();
        for(WebElement allOptions: options ) {
        	System.out.println("The all options are: " + allOptions.getText());
        }
        
        driver.close();
	}

}
