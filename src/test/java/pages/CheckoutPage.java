package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By backToProducts = By.id("back-to-products");

    public SelenideElement getFirstName() {
        return $(firstName);
    }
    public SelenideElement getLastName() {
        return $(lastName);
    }
    public SelenideElement getZipCode() {
        return $(zipCode);
    }
    public SelenideElement getContinueButton() {
        return $(continueButton);
    }
    public SelenideElement getFinishButton() {
        return $(finishButton);
    }
    public SelenideElement getBackToProducts() {
        return $(backToProducts);
    }

}
