package tasks;

import appobjects.InventoryAppObjects;
import appobjects.LoginAppObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTasks {

    private LoginAppObjects loginAppObjects;
    private InventoryAppObjects inventoryAppObjects;

    public LoginTasks(WebDriver driver) {
        loginAppObjects = new LoginAppObjects(driver);
        inventoryAppObjects = new InventoryAppObjects(driver);
    }

    public void efetuaLogin(String username, String password) {
        loginAppObjects.getUsernameTextfield().sendKeys(username);
        loginAppObjects.getPasswordTextfield().sendKeys(password);
        loginAppObjects.getLoginButton().click();
        Assert.assertEquals(inventoryAppObjects.getShoppingCartButton().isDisplayed(), true,
                "Deveria ter aparecido o botão do carrinho de compras após o login...");
    }

}
