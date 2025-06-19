package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features/add_product_to_wishlist.feature",
            glue = {"steps"},
            plugin = {"pretty", "html:target/cucumber-report.html"},
            publish = true
    )

public class AddToWishlistRunner{
}