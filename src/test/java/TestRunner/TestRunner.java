package TestRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/Features",glue = {"StepDefinitions"})
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(tags = "", features = {"src/test/resources/Features"}, glue = {"StepDefinitions"},
        plugin = {})
public class TestRunner extends AbstractTestNGCucumberTests{

}
