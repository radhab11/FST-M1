package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//Activity1_1
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity1_1"
)


//Activity1_2
//@RunWith(Cucumber.class)
//@CucumberOptions(
//	    features = "Features",
//	    glue = {"stepDefinitions"},
////	    tags = "@activity1_2"
//	)


//Activity1_3
//@RunWith(Cucumber.class)
//@CucumberOptions(
//	    features = "Features",
//	    glue = {"stepDefinitions"},
//	    tags = "@activity1_3"
//	)

//@RunWith(Cucumber.class)
//@CucumberOptions(
//	    features = "Features",
//	    glue = {"stepDefinitions"},
//	    tags = "@SmokeTest",
//	    strict = true
//	)


//Activity2_4
//@RunWith(Cucumber.class)
//@CucumberOptions(
//  features = "Features",
//  glue = {"stepDefinitions"},
//  tags = "@activity2_4"
//)


//Activity2_5
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = "Features",
//		glue = {"stepDefinitions"},
//		tags = "@activity2_5"
//)


////Activity6_1
//@RunWith(Cucumber.class)
//@CucumberOptions(
//    features = "Features",
//    glue = {"stepDefinitions"},
//    tags = "@SimpleAlert",
//    plugin = {"pretty"},
//    monochrome = true
//)


////Activity6_2
//@RunWith(Cucumber.class)
//@CucumberOptions(
//    features = "Features",
//    glue = {"stepDefinitions"},
//    tags = "@SimpleAlert",
//    plugin = {"html: test-reports"},
//    monochrome = true
//)


////Activity6_3
//@RunWith(Cucumber.class)
//@CucumberOptions(
//    features = "Features",
//    glue = {"stepDefinitions"},
//    tags = "@SimpleAlert",
//    plugin = {"json: test-reports/json-report.json"},
//    monochrome = true
//)

public class ActivitiesRunner {

}
