package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.HeaderPage;
import pages.ProductPage;
import pages.WishlistPage;

public class WishlistSteps {

    ProductPage productPage = new ProductPage();
    WishlistPage wishlistPage = new WishlistPage();
    HeaderPage headerPage = new HeaderPage();

    @And("I add iPhone 16 Pro Max 256GB White Titanium to wishlist")
    public void addToWishlist() {
        productPage.addToWishlist();
    }

    @And("I open the wishlist page")
    public void openWishlist() {
        headerPage.openWishlist();
        wishlistPage.waitUntilWishlistLoaded();
    }

    @Then("iPhone 16 Pro Max 256GB White Titanium should be in the wishlist")
    public void verifyWishlistItem() {
        wishlistPage.waitUntilWishlistLoaded();
        boolean found = wishlistPage.isProductInWishlist("iPhone 16 Pro Max 256GB White Titanium");
        Assertions.assertTrue(found, "Expected product is not visible in wishlist.");
    }
}
