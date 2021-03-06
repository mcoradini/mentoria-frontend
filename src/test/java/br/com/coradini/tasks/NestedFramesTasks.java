package br.com.coradini.tasks;

import br.com.coradini.appobjects.NestedFramesAppObjects;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import support.ExtentTestManager;
import support.ScreenShot;

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
                ExtentTestManager.log(Status.FAIL, "Valor nao foi encontrado...", ScreenShot.captureToBase64());
        }

    }

    public void verifyMiddleFrameContent() {
        try {
            Assert.assertTrue(nestedFramesAppObjects.getMiddleElement().getText().contentEquals("MIDDLE"));
            ExtentTestManager.log(Status.INFO, "Valor encontrado.", ScreenShot.captureToBase64());
        } catch (Exception e) {
                ExtentTestManager.log(Status.FAIL, "Valor nao foi encontrado...", ScreenShot.captureToBase64());
        }
    }

}
