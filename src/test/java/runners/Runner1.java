package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/"},
        glue = {"stepdefs", "pages","Hook"},
        //plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"}
        //plugin = { "pretty" },
        plugin = { "pretty",
        "html:test-output/HTML_Reports.html",
        "json:test-output/JSON_Report.json",
        "testng:test-output/XML_Rreports.xml"
        }
)

public class Runner1 extends AbstractTestNGCucumberTests {


}
