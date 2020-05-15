package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import support.DriverManagerFactory;
import support.DriverType;

public class TestBase extends DriverManagerFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        this.driver = setDriver(DriverType.CHROME);
        return driver;
    }

    //@AfterClass
    @AfterSuite
    public void tearDown() {
        quitDriver();
    }

}
