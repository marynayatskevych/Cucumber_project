package utils;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.DriverFactory.getDriver;

public class WaitUtils {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(Long.parseLong(ConfigReader.get("timeout")));

    private static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForText(By locator, String text) {
        return getWait().until(ExpectedConditions.textToBe(locator, text));
    }

    public static void waitForUrlToContain(String urlPart) {
        getWait().until(ExpectedConditions.urlContains(urlPart));
    }

    public static WebElement waitForPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
