package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    private static By headerTitleLabel = By.xpath("//span[contains(text(), 'Products')]");
    @FindBy (xpath = "//div[text()='49.99']/following-sibling::button")
    public WebElement addToCartTShirt;
    @FindBy (className = "shopping_cart_link")
    public WebElement goToCart;
    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    protected By getPageIdentifier() {
        return headerTitleLabel;
    }
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

}
