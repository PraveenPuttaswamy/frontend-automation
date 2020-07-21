package utils;

import base.WebDriverBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/** Wrapper for WebDriver commands
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class WebDriverUtil {

    public static WebDriverWait wait;

    /**
     * Navigate to a page with given Url
     * @param url String
     */
    public void navigateTo(String url) {
        WebDriverBase.driver.get(url);
    }

    /**
     * Wait for a page to load
     * @param timeInMilliseconds int
     */
    public void waitForPageLoad(int timeInMilliseconds) {
        WebDriverBase.driver.manage().timeouts().implicitlyWait(timeInMilliseconds, TimeUnit.MILLISECONDS);
    }

    /**
     * Get current page title
     * @return String
     */
    public String getPageTitle() {
        return WebDriverBase.driver.getTitle();
    }

    /**
     * Enter text into a input HTML element
     * @param element WebElement
     * @param value text to be entered
     */
    public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }

    /**
     * Click an element
     * @param element WebElement
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * Initialize Webdriver wait instance
     * @param timeoutInSeconds int
     */
    public void initWebDriverWait(int timeoutInSeconds) {
        wait = new WebDriverWait(WebDriverBase.driver, Duration.ofSeconds(timeoutInSeconds));
    }

    /**
     * Wait for an Element to be visible on page
     * @param element WebElement
     */
    public void waitElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for an Element to be visible and clickable
     * @param element WebElement
     */
    public void waitElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Validate if Element is displayed
     * @param element WebElement
     * @return boolean
     */
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Clear cookies in cannot logout gracefully
     */
    public void clearCookies() {
        WebDriverBase.driver.manage().deleteAllCookies();
    }

    /**
     * Maximize browser window
     */
    public void maximizeBrowser() {
        WebDriverBase.driver.manage().window().maximize();
    }

}
