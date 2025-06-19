package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class HeaderPage extends BasePage {

    private final By wishlistIcon = By.cssSelector("div.ico_hover_menu.wishlist_style a.wishlist");

    public void openWishlist() {
        WebElement wishlistLink = WaitUtils.waitForPresence(wishlistIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishlistLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", wishlistLink);
    }
}
