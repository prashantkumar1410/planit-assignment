package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CartPage extends LoadableComponent<CartPage> {
    private WebDriver driver;
    private LoadableComponent<ShopPage> parent;
    private By cartMessageHeader = By.className("cart-msg");

    CartPage(WebDriver driver, LoadableComponent<ShopPage> parent) {
        this.driver = driver;
        this.parent = parent;
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void verifyProductAdded(String count) {
        new PageOperations(driver).waitForElementUntil(cartMessageHeader);
        driver.findElement(cartMessageHeader).getText().contains(count);
    }
}
