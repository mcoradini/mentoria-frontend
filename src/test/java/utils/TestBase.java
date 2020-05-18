package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import support.DriverManagerFactory;
import support.DriverType;
import support.ExtentTestManager;

public class TestBase extends DriverManagerFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        this.driver = setDriver(DriverType.CHROME);
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        quitDriver();
        ExtentTestManager.endTest();
    }

}
