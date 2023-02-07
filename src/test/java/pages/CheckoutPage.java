package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By backToProducts = By.id("back-to-products");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }
    public WebElement getLastName() {
        return driver.findElement(lastName);
    }
    public WebElement getZipCode() {
        return driver.findElement(zipCode);
    }
    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }
    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }
    public WebElement getBackToProducts() {
        return driver.findElement(backToProducts);
    }

}
