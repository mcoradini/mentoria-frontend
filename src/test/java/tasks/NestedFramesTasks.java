package tasks;

import appobjects.NestedFramesAppObjects;
import org.openqa.selenium.WebDriver;

public class NestedFramesTasks {

    private NestedFramesAppObjects nestedFramesAppObjects;

    public NestedFramesTasks(WebDriver driver) {
        nestedFramesAppObjects = new NestedFramesAppObjects(driver);
    }

    public String getLeftFrameText() {
        return nestedFramesAppObjects.getLeftElements().getText();
    }

    public String getMiddleFrameText() {
        return nestedFramesAppObjects.getMiddleElement().getText();
    }

}
