package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base {

    WebDriver driver;

    DriverFactory driverFactory;

    public Base(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
        this.driver = driverFactory.getDriver();
    }

    public WebElement waitForVisibility(WebDriver driver,WebElement webElement,long timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,long timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public List<WebElement> numberOfElementsToBeLessThan(WebDriver driver, String xpath, long timeOut, int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.numberOfElementsToBeLessThan
                (By.xpath(xpath), number));
    }
}
