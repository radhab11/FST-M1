package testNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void accessingUrl() {
    	System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "password" }};
    }
    
    @Test (dataProvider = "Authentication")
    public void loginTestCase(String username, String password) {
    
    	WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
       
		userName.sendKeys(username);
		passWord.sendKeys(password);
      
        driver.findElement(By.cssSelector("button[type='submit']")).click();
      
        WebElement confirmMsg = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        System.out.println("The Confirmation Message is: " + confirmMsg.getText());
        Assert.assertEquals(confirmMsg.getText(), "Welcome Back, admin");
    }

    @AfterClass
    public void closeApp() {    
        driver.close();
    }

}