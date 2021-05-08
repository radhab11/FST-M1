package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_9_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/selects");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        WebElement selectedValue = driver.findElement(By.id("multi-value"));
        WebElement multiList = driver.findElement(By.id("multi-select"));
        Select multiSelect = new Select(multiList);
        
        if(multiSelect.isMultiple()) {
        	multiSelect.selectByVisibleText("Javascript");
        	System.out.println(selectedValue.getText());
        	multiSelect.selectByValue("node");
        	System.out.println(selectedValue.getText());
        	
        	for(int i=4; i<=6; i++) {
        		multiSelect.selectByIndex(i);
        		
        	}
        	System.out.println(selectedValue.getText());
        	
        }
        multiSelect.deselectByValue("node");
        System.out.println(selectedValue.getText());
        
        multiSelect.deselectByIndex(7);
        System.out.println(selectedValue.getText());
        
        List<WebElement> allSelectValues = multiSelect.getAllSelectedOptions();
        
        for(WebElement selectedOptions: allSelectValues) {
        	System.out.println(selectedOptions.getText());
        }
        
        multiSelect.deselectAll();
        System.out.println(selectedValue.getText());
        
        driver.close();

	}

}
