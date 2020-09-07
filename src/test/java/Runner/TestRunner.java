package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="Features"
,glue = "stepDefinitions",
monochrome = true,
dryRun = false,
plugin = {"pretty",
"html:Test_Report/Test-report",
"json:Test_Report/cucumber.json",
"junit:Test_Report/cucumber.xml"},
tags= {"@A"})

public class TestRunner {

}
