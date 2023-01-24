package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy (id = "first-name")
    public WebElement firstName;
    @FindBy (id = "last-name")
    public WebElement lastName;
    @FindBy (id = "postal-code")
    public WebElement zipCode;
    @FindBy (id = "continue")
    public WebElement continueButton;
    @FindBy (xpath = "//*[@class='summary_total_label' and text()='53.99']")
    public WebElement costWithTax;
    @FindBy (id = "finish")
    public WebElement finishButton;
    @FindBy (id = "back-to-products")
    public WebElement backToProducts;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

//    @Override
//    protected By getPageIdentifier() {
//        return costWithTax;
//    }

}
