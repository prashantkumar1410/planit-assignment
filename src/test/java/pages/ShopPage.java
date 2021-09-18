package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import java.util.Optional;
import static org.testng.AssertJUnit.assertTrue;

public class ShopPage extends LoadableComponent<ShopPage> {
    private WebDriver driver;
    private LoadableComponent<HomePage> parent;
    private By product = By.cssSelector(".product");
    private By productTitle = By.cssSelector(".product-title");
    private By buyButton=By.cssSelector("div p a");
    private By cart = By.cssSelector("li#nav-cart > a");
    public ShopPage(WebDriver driver, HomePage homePage) {
        this.driver = driver;
        this.parent = parent;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("ShopPage is not loaded!", driver.getCurrentUrl().equals(
                "https://jupiter.cloud.planittesting.com/#/shop"));
    }

    public ShopPage selectProductAndBuy(String toy) throws InterruptedException {

        new PageOperations(driver).waitForElementUntil(product);
        final Optional<WebElement> webElement = selectProduct(toy);
        webElement.ifPresent(element -> element.findElement(buyButton).click());
        return this;
    }

    public Optional<WebElement> selectProduct(String toy) {
        return driver.findElements(product)
                .stream()
                .filter(webElement -> webElement.findElement(productTitle).getText().equalsIgnoreCase(toy))
                .findFirst();
    }

    public CartPage navigateToCart() {
        driver.findElement(cart).click();
        return new CartPage(driver,this);
    }
}
