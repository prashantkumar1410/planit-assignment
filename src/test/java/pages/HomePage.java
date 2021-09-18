package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.PropertyReader;

import static org.testng.AssertJUnit.assertTrue;

public class HomePage extends LoadableComponent<HomePage> {

    WebDriver driver;
    private By contact = By.linkText("Contact");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void load() {
        driver.get(new PropertyReader().readProperty("applicationURL"));
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("HomePage is not loaded!", driver.getCurrentUrl().equals(
                new PropertyReader().readProperty("applicationURL")));
    }

    public ContactPage navigateToContactPage() {
        driver.findElement(contact).click();
        return new ContactPage(driver, this);
    }
}





