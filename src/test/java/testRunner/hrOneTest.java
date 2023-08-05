package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/login.feature"},
        glue = {"steps", "hooks"},
        plugin = {"pretty",
                "html:target/MyReport/cucumber",
                "json:target/MyReport/report.json",
                "junit:target/MyReport/report.xml"},
        tags = "@smoke"
)

public class hrOneTest extends AbstractTestNGCucumberTests {

}
