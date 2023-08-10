package com.hrOne.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ApplicationFileReader;
import utils.Base;
import utils.Constants;
import utils.DriverFactory;

public class LoginPage extends Base {
    WebDriver driver;
    ApplicationFileReader applicationFileReader;

    Constants constants;

    public LoginPage(DriverFactory driverFactory) {
        super(driverFactory);
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(driverFactory.getDriver(), this);
        applicationFileReader = new ApplicationFileReader();
        constants = new Constants();
    }

    @FindBy(how = How.ID, using = "hrone-username")
    WebElement userName;

    @FindBy(how = How.ID, using = "hrone-password")
    WebElement password;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='NEXT']")
    WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='LOG IN']")
    WebElement login;

    @FindBy(how = How.XPATH, using = "//div[@class='navbar-brand']")
    WebElement topNavBar;

    public void enterUsername() {
        waitForVisibility(driver, userName, constants.midWaitTIme);
        userName.clear();
        userName.sendKeys(applicationFileReader.getUsername());
    }

    public void enterPassword() {
        password.clear();
        waitForVisibility(driver, password, constants.midWaitTIme);
        password.sendKeys(applicationFileReader.getPassword());
    }

    public void clickNextButton() {
        waitForElementToBeClickable(driver, nextButton, constants.midWaitTIme);
        nextButton.click();
        waitTillProcessing();
    }

    public void clickLogin() {
        waitForElementToBeClickable(driver, login, constants.midWaitTIme);
        login.click();
        waitTillProcessing();
    }

    public void waitTillProcessing() {
        numberOfElementsToBeLessThan(driver, constants.processing, constants.midWaitTIme, 1);
    }

    public void waitTillLoading() {
        numberOfElementsToBeLessThan(driver, constants.loadingImage, constants.midWaitTIme, 1);
    }

    public void topNavBar() {
        waitForVisibility(driver, topNavBar, constants.midWaitTIme);
    }
}
