package br.com.coradini.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesAppObjects {

    private WebDriver driver;

    public NestedFramesAppObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLeftElements() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        return driver.findElement(By.cssSelector("body"));
    }

    public WebElement getMiddleElement() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        return driver.findElement(By.cssSelector("body"));
    }

}
