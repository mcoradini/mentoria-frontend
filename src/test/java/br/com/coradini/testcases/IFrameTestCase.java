package br.com.coradini.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import support.ExtentTestManager;
import utils.FileOperations;
import utils.TestBase;
import br.com.coradini.tasks.IFrameTasks;

public class IFrameTestCase extends TestBase {

    private final WebDriver driver = getDriver();
    private final IFrameTasks iFrameTasks = new IFrameTasks(driver);
    private final FileOperations fileOperations = new FileOperations();

    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        driver.navigate().to(fileOperations.readProperties("src/main/resources/properties/url.properties", "url.iframe"));
    }

    @Test
    public void iframeTest() {
        iFrameTasks.verifyIFrameHTMLText();
    }

}
