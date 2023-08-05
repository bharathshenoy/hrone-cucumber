package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class ScenarioHooks {

    WebDriver driver;

    DriverFactory driverFactory;

    public ScenarioHooks(DriverFactory driverFactory) {
        this.driver = driverFactory.getDriver();
        this.driverFactory = driverFactory;
    }

    @AfterStep
    public void AfterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES.BYTES);
            scenario.attach(src, "image/png", scenario.getName());
        }
    }
}
