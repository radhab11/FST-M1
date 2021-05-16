package project;

import java.net.MalformedURLException;
import java.net.URL;
//import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity_1 {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel4");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);


		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
	}
	@Test
	public void addNewTask() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		//	  wait.until(ExpectedConditions.visibilityOf(driver.findElementByAccessibilityId("Create new task")));

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
		MobileElement newTaskBtn = driver.findElementByAccessibilityId("Create new task");
		newTaskBtn.click();


		//	  wait.until(ExpectedConditions.visibilityOf(driver.findElementById("add_task_title")));

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		MobileElement addTaskTitle = driver.findElementById("add_task_title");
		addTaskTitle.sendKeys("Complete Activity with Google Tasks");
		//	  System.out.println("The Task 1 is: " + addTaskTitle.getAttribute("value"));


		MobileElement saveBtn = driver.findElementById("add_task_done");
		Assert.assertTrue(saveBtn.isEnabled());
		saveBtn.click();

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
		newTaskBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		addTaskTitle.sendKeys("Complete Activity with Google Keep");
		//	  System.out.println("The Task 2 is: " + addTaskTitle.getAttribute("value"));
		saveBtn.click();

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
		newTaskBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		addTaskTitle.sendKeys("Complete the second Activity Google Keep");
		//	  System.out.println("The Task 3 is: " + addTaskTitle.getAttribute("value"));
		saveBtn.click();



		//      List<MobileElement> taskItems = driver.findElementsByXPath("//android.widget.TextView[@class='android.widget.TextView']");

		//      List<MobileElement> taskItems = driver.findElementsByXPath("//android.widget.TextView[@resource-id='task_name']");


	}


	@AfterClass 
	public void closeDriver() {
		driver.quit();
	}
}
