package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrameAppObjects {

    private WebDriver driver;

    public IFrameAppObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getIFrameTextfield() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("mce_0_ifr");
        return driver.findElement(By.id("tinymce"));
    }

}
