package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import support.DriverManagerFactory;
import support.DriverType;
import support.ExtentTestManager;

public class TestBase extends DriverManagerFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        driver = setDriver(DriverType.CHROME);
        return driver;
    }

    @AfterSuite
    public void tearDown() {
        quitDriver();
        ExtentTestManager.endTest();
    }

}
