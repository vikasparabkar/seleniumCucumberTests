package RunnerPackage;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith	(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/features/test.feature",
		glue = {"StepDefinations"},
		plugin = {"pretty", "html:target/cucumber-reports.html"},	//Normal Report Generation
//		plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},	//Allure Report
	    monochrome = true,
	    dryRun = false
	    //tags = "@outline"
		)

public class TestRunner extends AbstractTestNGCucumberTests{
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}
