package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_8_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/Users/radhab/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/tables");

        String pageTitle = driver.getTitle();
        System.out.println("The Title is: " + pageTitle);
        
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

        System.out.println("No of columns are: " + columns.size());
        System.out.println("No of rows are: " + rows.size());
	
        WebElement cellValueBefore = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
	
        System.out.println("Second row, second column value(Before sorting): " + cellValueBefore.getText());

        WebElement sortTable = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]"));
        sortTable.click();

        WebElement cellValueAfter = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
	
        System.out.println("Second row, second column value(After sorting): " + cellValueAfter.getText());
	
        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
	
        System.out.println("Table footer values: " + footer.getText());
	
        driver.close();

	}

}
