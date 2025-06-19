package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import static utils.WaitUtils.waitForVisibility;

public class WishlistPage extends BasePage {

    private final By wishlistContainer = By.cssSelector(".section_product");
    private final By wishlistItemTitles = By.cssSelector("div.section_product_name.list-sec-name > a");

    public void waitUntilWishlistLoaded() {
        waitForVisibility(wishlistContainer);
    }

    public boolean isProductInWishlist(String productName) {
        List<WebElement> items = driver.findElements(wishlistItemTitles);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement item : items) {
            String text = (String) js.executeScript("return arguments[0].innerText;", item);
            if (text.contains(productName)) {
                return true;
            }
        }
        return false;
    }
}
