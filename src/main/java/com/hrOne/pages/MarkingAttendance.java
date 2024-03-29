package com.hrOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverFactory;

import java.time.Duration;

public class MarkingAttendance {

    WebDriver driver;

    public MarkingAttendance(DriverFactory driverFactory) {
        this.driver = driverFactory.getDriver();
        PageFactory.initElements(driverFactory.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Mark attendance']")
    WebElement markAttendanceMainButton;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Mark attendance']")
    WebElement markAttendanceButton;

    @FindBy(how = How.XPATH, using = "//textarea[@id='mat-input-16']")
    WebElement writeRemarks;


    public void markAttendance() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(markAttendanceMainButton));
        Assert.assertTrue(markAttendanceMainButton.isDisplayed());
        markAttendanceMainButton.click();
        Thread.sleep(5000);
        writeRemarks.sendKeys("Marking Attendance");
        Assert.assertTrue(markAttendanceButton.isDisplayed());
        markAttendanceButton.click();
        waitTillProcessing();
    }

    public void closePopUps() {
        try {
            driver.findElement(By.xpath("//a[normalize-space()='May be Later']")).click();
            System.out.println("May be Later button clicked");
        } catch (Exception ignored) {
        }

        try {
            driver.findElement(By.xpath(" //div[@class='dialogContentInner ng-tns-c75-172']//em[@class='material-icons'][normalize-space()='clear']")).click();
            System.out.println("Clear button clicked");
        } catch (Exception ignored) {
        }

        try {
            driver.findElement(By.xpath("//div[@role='dialog']//div//div//div//i[contains(text(),'clear')]")).click();
            System.out.println("Clear button clicked");
        } catch (Exception ignored) {
        }
        try {
            driver.findElement(By.xpath("//div[@role='dialog']//div//div//i[contains(text(),'clear')]")).click();
            System.out.println("Clear button clicked");
        } catch (Exception ignored) {
        }
        try {
            driver.findElement(By.xpath("//span[@class='material-icons cursor-pointer']")).click();
            System.out.println("Clear button clicked");
        } catch (Exception ignored) {
        }
        try {
            driver.findElement(By.xpath("//div[contains(@class,'dialog-wrapper')]//" +
                    "i[@class='material-icons'][normalize-space()='clear']")).click();
            System.out.println("Clear button clicked");
        } catch (Exception ignored) {
        }
    }

    public void waitTillProcessing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan
                (By.xpath("(//span[normalize-space()='Processing'])[1]"), 1));
    }
}
