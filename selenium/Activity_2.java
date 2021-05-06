package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("The Title Is:" + driver.getTitle());
        
        WebElement idLocator = driver.findElement(By.id("about-link"));
        System.out.println("The Text in element by ID Is:" + idLocator.getText());
        
        WebElement classNameLocator = driver.findElement(By.className("green"));
        System.out.println("The Text in element by class Is:" + classNameLocator.getText());
        
        WebElement cssLocator = driver.findElement(By.cssSelector(".green"));
        System.out.println("The Text in element by css Is:" + cssLocator.getText());
        
        WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
        System.out.println("The Text in element by linktext Is:" + linkTextLocator.getText());
        
        driver.close();


	}

}
