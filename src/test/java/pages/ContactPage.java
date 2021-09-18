package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.Constants;
import utils.PropertyReader;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ContactPage extends LoadableComponent<ContactPage> {
    private WebDriver driver;
    private LoadableComponent<HomePage> parent;
    private By submit = By.linkText("Submit");
    private By forename = By.id("forename");
    private By email = By.id("email");
    private By message = By.id("message");
    private By headerMessage = By.id("header-message");
    private By successAlert = By.cssSelector(".alert.alert-success");
    private By foreNameError = By.id("forename-err");
    private By emailError = By.id("email-err");
    private By messageError = By.id("message-err");


    ContactPage(WebDriver driver, LoadableComponent<HomePage> parent) {
        this.driver = driver;
        this.parent = parent;
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

    public ContactPage verifyValidationError() {

        final String text = driver.findElement(headerMessage).getText();
        assertEquals(text, Constants.feedbackMessage);
        return this;
    }

    public ContactPage enterMandatoryField() {
        driver.findElement(forename).sendKeys(Constants.forename);
        driver.findElement(email).sendKeys(Constants.email);
        driver.findElement(message).sendKeys(Constants.message);
        return this;
    }

    public ContactPage enterInvalidDataInMandatoryField() {
        driver.findElement(forename).sendKeys("");
        driver.findElement(email).sendKeys(Constants.invalidEmail);
        driver.findElement(message).sendKeys("");
        return this;
    }

    public ContactPage verifySuccessMessage() {
        new PageOperations(driver).waitForElementUntil(successAlert);
        assertTrue(driver.findElement(successAlert).getText().contains("we appreciate your feedback."));
        return this;
    }

    public void verifyMandatoryFieldValidationError() {
        driver.findElement(forename).getText().equals(Constants.forenameError);
        driver.findElement(email).getText().equals(Constants.emailError);
        driver.findElement(message).getText().equals(Constants.messageError);
    }
}
