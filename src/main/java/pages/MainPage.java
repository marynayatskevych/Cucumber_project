package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    private final By iphoneMenu = By.xpath("//a[@href='/ua/iphone/']//span[text()='iPhone']");
    private final By iphone16ProMaxLink = By.xpath("//a[@href='/ua/iphone/iphone-16-pro-max/']");

    public void openIphone16ProMaxSection() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(iphoneMenu)).perform();
        click(iphone16ProMaxLink);
    }


}
