package br.com.coradini.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviderClass;
import support.ExtentTestManager;
import utils.FileOperations;
import utils.TestBase;
import br.com.coradini.tasks.LoginTasks;

public class LoginTestCase extends TestBase {

    private final WebDriver driver = getDriver();
    private final LoginTasks login = new LoginTasks(driver);
    private final FileOperations fileOperations = new FileOperations();

    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        driver.navigate().to(fileOperations.readProperties("src/main/resources/properties/url.properties", "url.login"));
    }

    @Test(dataProvider = "login-users", dataProviderClass = DataProviderClass.class)
    public void loginTest(String user, String password) {
        login.efetuaLogin(user, password);
    }

//    @Test(dataProvider = "login-users-csv", dataProviderClass = DataProviderClass.class)
//    public void loginCsvTest(String user, String pass) {
//        login.efetuaLogin(user, pass);
//    }

}
