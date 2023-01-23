package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final By nameProducts = By.xpath("//*[text()='Sauce Labs Fleece Jacket']");

    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameProducts;
    }

    public WebElement getCheckoutButton () {
        return driver.findElement(checkoutButton);
    }
}
