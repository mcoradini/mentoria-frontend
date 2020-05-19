package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.ExtentTestManager;
import utils.TestBase;
import tasks.NestedFramesTasks;

public class NestedFramesTestCase extends TestBase {

    private WebDriver driver = getDriver();;
    private NestedFramesTasks nestedFramesTasks = new NestedFramesTasks(driver);;

    //TODO Criar arquivo de config com as URLs para os sites.
    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    public void nestedFramesTest() {
        nestedFramesTasks.verifyLeftFrameContent();
        nestedFramesTasks.verifyMiddleFrameContent();
    }

}
