package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class DriverFactory {

    public WebDriver driver;
    final String USERNAME = "dplusinawsdev_W6HSG7";
    final String AUTOMATE_KEY = "9oyACwGK1LJBkqz2qhmD";
    final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("browserstack.geoLocation", "IN");
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "11");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Object response = jse.executeScript("browserstack_executor: {\"action\": \"getSessionDetails\"}");
        JSONObject json = (JSONObject) new JSONParser().parse((String) response);
        String sessionID = (String) json.get("hashed_id");
        System.out.println("BrowserStack sessionID.......... " + sessionID);
        driver.manage().window().maximize();
    }
}
