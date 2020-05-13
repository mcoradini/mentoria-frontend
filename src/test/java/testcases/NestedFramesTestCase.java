package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import support.TestBase;
import tasks.NestedFramesTasks;

public class NestedFramesTestCase extends TestBase {

    @Test
    public void nestedFramesTest() {
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        NestedFramesTasks nestedFramesTasks = new NestedFramesTasks(driver);

        Assert.assertTrue(nestedFramesTasks.getLeftFrameText().contentEquals("LEFT"));
        Assert.assertTrue(nestedFramesTasks.getMiddleFrameText().contentEquals("MIDDLE"));

        System.out.println(nestedFramesTasks.getLeftFrameText());
        System.out.println(nestedFramesTasks.getMiddleFrameText());
    }
}
