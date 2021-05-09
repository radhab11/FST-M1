package testNGActivities;

import org.testng.annotations.Test;

public class Activity_4_DemoOne {
	@Test(priority=1)
	public void firstTestCase() {
		System.out.println("I'm in first test case from demoOne Class");
	}

	@Test(priority=2)
	public void secondTestCase() {
		System.out.println("I'm in second test case from demoOne Class");
	}
}
