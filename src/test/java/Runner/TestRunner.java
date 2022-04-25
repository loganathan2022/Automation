package Runner;


import Util.GlobalFunction;
import Util.ReportGeneration;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"Stepdef"},
        tags = {"@TC1_Admin_CorrectCredentials,@TC2_Admin_InCorrectCredentials"},
        plugin = { "json:target/cucumber.json",
                "html:target/cucumber-reports/html"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {


    @AfterSuite
    public void TearDownReportGeneration() throws Exception {
GlobalFunction.driver.quit();
       ReportGeneration.generateJVMReport();

    }





}







