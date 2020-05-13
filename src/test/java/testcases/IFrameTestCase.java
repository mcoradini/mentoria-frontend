package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import support.TestBase;
import tasks.IFrameTasks;

public class IFrameTestCase extends TestBase {

    private static final String TXT_VALUE = "Your content goes here.";

    @Test
    public void iframeTest() {
        driver.navigate().to("http://the-internet.herokuapp.com/iframe");

        IFrameTasks iFrameTasks = new IFrameTasks(driver);

        Assert.assertEquals(iFrameTasks.returnIFrameHTMLTextfieldValue(), TXT_VALUE);

        System.out.println(iFrameTasks.returnIFrameHTMLTextfieldValue());
    }

}
