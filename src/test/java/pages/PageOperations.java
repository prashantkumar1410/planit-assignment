package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageOperations {

    WebDriver driver;

    public PageOperations(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementUntil(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

}
