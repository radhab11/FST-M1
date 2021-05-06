package SeleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        driver.close();

	}

}
