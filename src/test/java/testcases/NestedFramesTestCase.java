package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestBase;
import tasks.NestedFramesTasks;

public class NestedFramesTestCase extends TestBase {

    private WebDriver driver = getDriver();;
    private NestedFramesTasks nestedFramesTasks = new NestedFramesTasks(driver);;

    @BeforeMethod
    public void setUp() {
        driver.get("http://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    public void nestedFramesTest() {
        Assert.assertTrue(nestedFramesTasks.getLeftFrameText().contentEquals("LEFT"));
        Assert.assertTrue(nestedFramesTasks.getMiddleFrameText().contentEquals("MIDDLE"));

        System.out.println(nestedFramesTasks.getLeftFrameText());
        System.out.println(nestedFramesTasks.getMiddleFrameText());
    }

}
