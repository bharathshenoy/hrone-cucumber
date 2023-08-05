package steps;

import com.hrOne.pages.LoginPage;
import com.hrOne.pages.MarkingAttendance;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ApplicationFileReader;
import utils.DriverFactory;

public class LoginSteps {
    DriverFactory driverFactory;
    LoginPage loginPage;

    MarkingAttendance markingAttendance;
    ApplicationFileReader applicationFileReader;
    WebDriver driver;

    public LoginSteps(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
        this.driver = driverFactory.getDriver();
        loginPage = new LoginPage(driverFactory);
        markingAttendance = new MarkingAttendance(driverFactory);
        applicationFileReader = new ApplicationFileReader();
    }

    @Given("user enters the HrOne website url")
    public void userEntersHrOneUrl() throws InterruptedException {
        driver.get(applicationFileReader.getLoginLink());
        Thread.sleep(5000);
    }

    @Given("user is in hrOne login page")
    public void userInHrOneLoginPage() {
        Assert.assertEquals("https://app.hrone.cloud/login", driver.getCurrentUrl());
    }

    @And("user clicks on username field and enters username")
    public void userEntersUsername() {
        loginPage.enterUsername();
    }

    @And("user clicks on Next button")
    public void userClicksOnNext() {
        loginPage.clickNextButton();
    }

    @And("user clicks on password field and enters password")
    public void userEntersPassword() {
        loginPage.enterPassword();
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLogin();
        loginPage.waitTillLoading();

    }

    @Then("user will be taken to HrOne one home page")
    public void userOnHronePage() {
        Assert.assertEquals(applicationFileReader.getHomePageLink(), driver.getCurrentUrl());
        markingAttendance.closePopUps();
        loginPage.topNavBar();
    }
}
