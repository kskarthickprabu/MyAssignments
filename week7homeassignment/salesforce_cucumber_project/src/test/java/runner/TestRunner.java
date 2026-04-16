package runner;

import io.cucumber.testng.CucumberOptions;
import steps.BaseClass;

@CucumberOptions(features = "src/test/resources/CreateAccount.feature",glue="steps")
public class TestRunner extends BaseClass {


    

}
