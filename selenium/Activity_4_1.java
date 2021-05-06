package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("The Title Is:" + driver.getTitle());
        
        WebElement aboutUsBtn = driver.findElement(By.xpath("/html/body/div/div/div/a"));
        aboutUsBtn.click();
        System.out.println("The Heading Is:" + driver.getTitle());

        driver.close();
	}

}
