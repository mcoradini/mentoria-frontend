package tasks;

import appobjects.NestedFramesAppObjects;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import support.ExtentTestManager;
import support.ScreenShot;

import java.io.IOException;

public class NestedFramesTasks {

    private NestedFramesAppObjects nestedFramesAppObjects;

    public NestedFramesTasks(WebDriver driver) {
        nestedFramesAppObjects = new NestedFramesAppObjects(driver);
    }

    public void verifyLeftFrameContent() {
        try {
            Assert.assertTrue(nestedFramesAppObjects.getLeftElements().getText().contentEquals("LEFT"));
            ExtentTestManager.log(Status.INFO, "Valor encontrado.", ScreenShot.captureToBase64());
        } catch (Exception e) {
            try {
                ExtentTestManager.log(Status.FAIL, "Valor nao foi encontrado...", ScreenShot.captureToBase64());
            } catch (IOException io) {
                e.getMessage();
            }
        }

    }

    public void verifyMiddleFrameContent() {
        try {
            Assert.assertTrue(nestedFramesAppObjects.getMiddleElement().getText().contentEquals("MIDDLE"));
            ExtentTestManager.log(Status.INFO, "Valor encontrado.", ScreenShot.captureToBase64());
        } catch (Exception e) {
            try {
                ExtentTestManager.log(Status.FAIL, "Valor nao foi encontrado...", ScreenShot.captureToBase64());
            } catch (IOException io) {
                e.getMessage();
            }
        }
    }

}
