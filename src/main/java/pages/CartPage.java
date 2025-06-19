package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.WaitUtils.waitForVisibility;

public class CartPage extends BasePage {

    private final By basketList = By.id("basket-item-list");
    private final By cartItem = By.xpath("//tr[contains(@class,'basket-items-list-item') and contains(., 'White Titanium')]");

    public boolean isProductVisibleInCart() {
        try {
            WebElement element = waitForVisibility(cartItem);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void waitUntilCartLoaded() {
        waitForVisibility(basketList);
    }
}
