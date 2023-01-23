package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final By headerTitleLabelLocator = By.xpath("//span[contains(text(), 'Products')]");
    private final By addToCartTShirt = By.xpath("//div[text()='49.99']/following-sibling::button");
    private final By goToCart = By.className("shopping_cart_link");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public WebElement getAddToCartTShirt() {
        return driver.findElement(addToCartTShirt);
    }

    public WebElement getGoToCart() {
        return driver.findElement(goToCart);
    }
}
