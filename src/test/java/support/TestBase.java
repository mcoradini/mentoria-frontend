package support;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestBase extends DriverManagerFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        this.driver = setDriver(DriverType.CHROME);
        return driver;
    }

    @AfterClass
    public void tearDown() {
        quitDriver();
    }

}
