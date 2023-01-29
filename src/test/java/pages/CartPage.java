package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy (xpath = "//*[text()='Sauce Labs Fleece Jacket']")
    public WebElement nameProducts;
    @FindBy (id = "checkout")
    public WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String showCartMessage() {
        return "Massage about cart";
    }

//    @Override
//    protected By getPageIdentifier() {
//        return nameProducts;
//    }

}
