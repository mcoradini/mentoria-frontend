package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import support.ExtentTestManager;
import utils.TestBase;
import tasks.IFrameTasks;

public class IFrameTestCase extends TestBase {

    private WebDriver driver = getDriver();
    private IFrameTasks iFrameTasks = new IFrameTasks(driver);

    //TODO Criar arquivo de config com as URLs para os sites.
    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        driver.navigate().to("http://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iframeTest() {
        iFrameTasks.verifyIFrameHTMLText();
    }

}
