package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;


public class ScenarioHooks {

    DriverFactory driverFactory;

    public ScenarioHooks(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @Before
    public void setUp() {
        driverFactory.setDriver();
    }

    @After
    public void tearDown() {
        driverFactory.getDriver().quit();
    }

}
