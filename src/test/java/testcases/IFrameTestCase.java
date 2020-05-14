package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import support.TestBase;
import tasks.IFrameTasks;

public class IFrameTestCase extends TestBase {

    private WebDriver driver;
    private IFrameTasks iFrameTasks;
    private static final String TXT_VALUE = "Your content goes here.";

    @BeforeMethod
    public void setUp() {
        this.driver = getDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/iframe");
        iFrameTasks = new IFrameTasks(driver);
    }

    @Test
    public void iframeTest() {
        Assert.assertEquals(iFrameTasks.returnIFrameHTMLTextfieldValue(), TXT_VALUE);
        System.out.println("Valor encontrado no iframe: " + iFrameTasks.returnIFrameHTMLTextfieldValue());
    }

}
