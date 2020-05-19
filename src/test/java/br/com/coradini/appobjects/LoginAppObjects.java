package br.com.coradini.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAppObjects {

    private WebDriverWait wait;

    public LoginAppObjects(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
    }

    public WebElement getUsernameTextfield() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
    }

    public WebElement getPasswordTextfield() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }

    public WebElement getLoginButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn_action")));
    }

}
