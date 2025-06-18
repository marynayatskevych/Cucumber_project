package utils;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(Long.parseLong(ConfigReader.get("timeout")));

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), DEFAULT_TIMEOUT);
    }

    public static void waitForPageToLoad() {
        getWait().until(webDriver -> ((String) ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")).equals("complete"));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForInvisibility(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForText(By locator, String text) {
        return getWait().until(ExpectedConditions.textToBe(locator, text));
    }

    public static boolean waitForAttributeToBe(By locator, String attribute, String value) {
        return getWait().until(ExpectedConditions.attributeToBe(locator, attribute, value));
    }

    public static boolean waitForAlert() {
        return getWait().until(ExpectedConditions.alertIsPresent()) != null;
    }

    public static void waitForFrameToBeAvailableAndSwitchToIt(By locator) {
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public static void waitForElementToBeSelected(By locator) {
        getWait().until(ExpectedConditions.elementToBeSelected(locator));
    }
}
