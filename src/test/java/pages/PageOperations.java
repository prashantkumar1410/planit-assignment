package pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


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
