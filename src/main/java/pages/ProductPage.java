package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.WaitUtils.waitForClickability;
import static utils.WaitUtils.waitForVisibility;

public class ProductPage extends BasePage {

    private final By iphone16WhiteTitanium = By.xpath("//div[@class='section_product_name' and contains(., 'White Titanium')]");
    private final By buyButton = By.xpath("//div[contains(@class,'addtocart') and text()[contains(., 'Купити')]]");
    private final By modalTitle = By.cssSelector("div#basket_op .title_bit_basket");
    private final By modalItemName = By.xpath("//div[@class='section_product_name']//a[contains(text(),'iPhone 16 Pro Max 256GB White Titanium')]");
    private final By productGrid = By.cssSelector("div.section_products");
    private final By cartItemTitle = By.xpath("//span[@data-entity='basket-item-name' and contains(., 'iPhone 16 Pro Max')]");
    private final By productCard = By.xpath("//div[contains(@class,'section_product') and .//div[contains(@class,'section_product_name') and contains(., 'iPhone 16 Pro Max 256GB White Titanium')]]");
    private final By buyButtonInsideCard = By.xpath(".//div[contains(@class,'addtocart') and contains(text(), 'Купити')]");
    private final By wishIcon = By.xpath("//div[contains(@class,'section_product') and contains(., 'White Titanium')]//div[contains(@class,'addtowish')]");

    public void waitForProductsToLoad() {
        waitForVisibility(productGrid);
    }

    public void clickBuy() {
        click(buyButton);
    }

    public void clickBuyOnIphone16WhiteTitaniumCard() {
        WebElement card = waitForVisibility(productCard);
        WebElement buyButton = card.findElement(buyButtonInsideCard);
        buyButton.click();
    }

    public void addToWishlist() {
        waitForClickability(wishIcon).click();
    }
}

