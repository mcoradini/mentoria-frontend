package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.TestBase;
import tasks.LoginTasks;

public class LoginTestCase extends TestBase {

    private WebDriver driver;
    private LoginTasks login;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        login = new LoginTasks(driver);
        driver.navigate().to("https://www.saucedemo.com/index.html");
    }

    @Test
    public void loginTest() {
        login.efetuaLogin("standard_user", "secret_sauce");
    }

}
