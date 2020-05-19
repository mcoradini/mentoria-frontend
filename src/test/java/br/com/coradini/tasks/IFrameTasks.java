package tasks;

import appobjects.IFrameAppObjects;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import support.ExtentTestManager;
import support.ScreenShot;

public class IFrameTasks {

    private IFrameAppObjects iFrameAppObjects;
    private static final String TXT_VALUE = "Your content goes here.";

    public IFrameTasks(WebDriver driver) {
        iFrameAppObjects = new IFrameAppObjects(driver);
    }

    public void verifyIFrameHTMLText() {
        try {
            Assert.assertEquals(iFrameAppObjects.getIFrameTextfield().getText(), TXT_VALUE);
            ExtentTestManager.log(Status.INFO, "Valor encontrado.", ScreenShot.captureToBase64());
        } catch (Exception e) {
                ExtentTestManager.log(Status.FAIL, "Valor nao foi encontrado...", ScreenShot.captureToBase64());
        }
    }

}
