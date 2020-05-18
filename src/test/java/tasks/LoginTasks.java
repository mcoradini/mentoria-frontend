package tasks;

import appobjects.InventoryAppObjects;
import appobjects.LoginAppObjects;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import support.ExtentTestManager;
import support.ScreenShot;

import java.io.IOException;

public class LoginTasks {

    private LoginAppObjects loginAppObjects;
    private InventoryAppObjects inventoryAppObjects;

    public LoginTasks(WebDriver driver) {
        loginAppObjects = new LoginAppObjects(driver);
        inventoryAppObjects = new InventoryAppObjects(driver);
    }

    public void efetuaLogin(String username, String password) {
        try {
            loginAppObjects.getUsernameTextfield().sendKeys(username);
            loginAppObjects.getPasswordTextfield().sendKeys(password);
            loginAppObjects.getLoginButton().click();
            Assert.assertEquals(inventoryAppObjects.getShoppingCartButton().isDisplayed(), true,
                    "Deveria ter aparecido o botão do carrinho de compras após o login...");
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
