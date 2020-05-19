package br.com.coradini.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.ExtentTestManager;
import utils.FileOperations;
import utils.TestBase;
import br.com.coradini.tasks.NestedFramesTasks;

public class NestedFramesTestCase extends TestBase {

    private final WebDriver driver = getDriver();;
    private final NestedFramesTasks nestedFramesTasks = new NestedFramesTasks(driver);
    private final FileOperations fileOperations = new FileOperations();

    @BeforeMethod
    public void setUp(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        driver.navigate().to(fileOperations.readProperties("src/main/resources/properties/url.properties", "url.nested"));
    }

    @Test
    public void nestedFramesTest() {
        nestedFramesTasks.verifyLeftFrameContent();
        nestedFramesTasks.verifyMiddleFrameContent();
    }

}
