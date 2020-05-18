package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviderClass;
import support.ExtentTestManager;
import utils.TestBase;
import tasks.LoginTasks;

public class LoginTestCase extends TestBase {

    private WebDriver driver = getDriver();
    private LoginTasks login = new LoginTasks(driver);

    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        driver.navigate().to("https://www.saucedemo.com/index.html");
    }

    @Test(dataProvider = "login-users", dataProviderClass = DataProviderClass.class)
    public void loginTest(String user, String password) {
        login.efetuaLogin(user, password);
    }

    @Test(dataProvider = "login-users-csv", dataProviderClass = DataProviderClass.class)
    public void loginCsvTest(String user, String pass) {
        login.efetuaLogin(user, pass);
    }

}
