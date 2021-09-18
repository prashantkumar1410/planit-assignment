package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.PropertyReader;

import static org.testng.AssertJUnit.assertTrue;

public class ContactPage extends LoadableComponent<ContactPage> {
    private WebDriver driver;
    private LoadableComponent<HomePage> parent;
    private By submit = By.linkText("Submit");


    ContactPage(WebDriver driver, LoadableComponent<HomePage> parent) {
        this.driver = driver;
        this.parent = parent;
    }


    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    protected void load() {
        driver.get(new PropertyReader().readProperty("applicationURL"));
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("ContactPage is not loaded!", driver.getCurrentUrl().equals(
                new PropertyReader().readProperty("applicationURL")));
    }

    public ContactPage clickSubmit() {
        new PageOperations(driver).waitForElementUntil(submit);
        driver.findElement(submit).click();
        return this;
    }
}
