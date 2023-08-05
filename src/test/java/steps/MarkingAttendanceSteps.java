package steps;

import com.hrOne.pages.LoginPage;
import com.hrOne.pages.MarkingAttendance;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.DriverFactory;

public class MarkingAttendanceSteps {

    DriverFactory driverFactory;
    MarkingAttendance markingAttendance;
    LoginPage loginPage;
    WebDriver driver;

    public MarkingAttendanceSteps(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(driverFactory.getDriver(), this);
        markingAttendance = new MarkingAttendance(driverFactory);
        loginPage = new LoginPage(driverFactory);
    }

    @Given("user performs valid login operation")
    public void userLogin() {
        loginPage.enterUsername();
        loginPage.clickNextButton();
        loginPage.enterPassword();
        loginPage.clickLogin();
        loginPage.waitTillLoading();
    }

    @Given("user in in HrOne home page")
    public void userIsInHrOneHomePage() {
        Assert.assertEquals("https://app.hrone.cloud/app", driver.getCurrentUrl());
    }

    @When("user closes all the pop ups")
    public void userClosesAllPopUps() {
        markingAttendance.closePopUps();
    }

    @And("user will mark the attendance")
    public void userMarksAttendance() throws InterruptedException {
        markingAttendance.markAttendance();
    }
}
