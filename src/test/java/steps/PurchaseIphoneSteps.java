package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import utils.WaitUtils;

public class PurchaseIphoneSteps {
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Given("I am on the istore main page")
    public void openMainPage() {
        mainPage.navigateToBaseUrl();
    }

    @When("I select iPhone 16 Pro Max from the menu")
    public void selectIphoneSection() {
        mainPage.openIphone16ProMaxSection();
    }

    @And("I choose iPhone 16 Pro Max 256GB White Titanium")
    public void chooseProductVariant() {
        productPage.waitForProductsToLoad();
        productPage.clickBuyOnIphone16WhiteTitaniumCard();
    }

    @And("I click Buy button")
    public void clickBuyButton() {
        productPage.clickBuy();
        WaitUtils.waitForUrlToContain("/personal/cart/");
    }

    @Then("Product should appear in the cart")
    public void checkCardProduct() {
        cartPage.waitUntilCartLoaded();
        assertTrue(cartPage.isProductVisibleInCart(), "Expected product is not visible in cart");
    }
}
