package com.hrOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(DriverFactory driverFactory) {
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(driverFactory.getDriver(), this);
    }

    @FindBy(how = How.ID, using = "hrone-username")
    WebElement userName;

    @FindBy(how = How.ID, using = "hrone-password")
    WebElement password;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='NEXT']")
    WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='LOG IN']")
    WebElement login;

    public void enterUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.clear();
        userName.sendKeys("bharath.s@robosoftin.com");
    }

    public void enterPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        password.clear();
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("IamAwesome7H*");
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        waitTillProcessing();
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
        waitTillProcessing();
    }

    public void waitTillProcessing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan
                (By.xpath("(//span[normalize-space()='Processing'])[1]"), 1));
    }


}
