package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"steps", "hooks"},
        plugin = {"pretty",
                "html:target/MyReport/cucumber.html",
                "json:target/MyReport/report.json",
                "junit:target/MyReport/report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@smoke"
)

public class hrOneTest extends AbstractTestNGCucumberTests {

}
