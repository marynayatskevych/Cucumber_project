package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverFactory {

    private static DriverFactory instance;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriver webDriver;
            switch (System.getProperty("browser", "chrome")) {
                case "firefox":
                    log.info("Starting Firefox browser");
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "edge":
                    log.info("Starting Edge browser");
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                case "safari":
                    log.info("Starting Safari browser");
                    WebDriverManager.safaridriver().setup();
                    webDriver = new SafariDriver();
                    break;
                case "ie":
                    log.info("Starting Internet Explorer browser");
                    WebDriverManager.iedriver().setup();
                    webDriver = new InternetExplorerDriver();
                    break;
                default:
                    log.info("Starting Chrome browser");
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
            }
            webDriver.manage().window().maximize();
            log.info("Browser started successfully");
            driver.set(webDriver);
        }
        return driver.get();
    }

    public static void closeDriver() {
        log.info("Closing the browser");
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

