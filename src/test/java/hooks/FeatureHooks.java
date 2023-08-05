package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;


public class FeatureHooks {

    DriverFactory driverFactory;

    public FeatureHooks(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @Before(order = 1)
    public void setUp() {
        driverFactory.setDriver();
    }

    @After
    public void tearDown() {
        driverFactory.getDriver().quit();
    }

}
