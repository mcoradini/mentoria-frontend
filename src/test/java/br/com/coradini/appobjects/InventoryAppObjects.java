package br.com.coradini.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryAppObjects {

    private WebDriverWait wait;

    public InventoryAppObjects(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
    }

    public WebElement getShoppingCartButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shopping_cart_container")));
    }

}
