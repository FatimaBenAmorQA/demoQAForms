package com.e2etests.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "src/spec/features" }, plugin = { "pretty", "html:target/cucumber-report.html",
				"json:target/cucumber-report.json" }, tags = ("@RemplirLeFormulaireStudentRegistrationForm"),
		// glue = {"com.e2etests.automation.step_definitions"},
		monochrome = true, snippets = CAMELCASE

)

public class RunWebSuiteTest {

}
