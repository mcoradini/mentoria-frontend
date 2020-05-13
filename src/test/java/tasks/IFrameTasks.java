package tasks;

import appobjects.IFrameAppObjects;
import org.openqa.selenium.WebDriver;

public class IFrameTasks {

    private IFrameAppObjects iFrameAppObjects;

    public IFrameTasks(WebDriver driver) {
        iFrameAppObjects = new IFrameAppObjects(driver);
    }

    public String returnIFrameHTMLTextfieldValue() {
        return iFrameAppObjects.getIFrameTextfield().getText();
    }

}
