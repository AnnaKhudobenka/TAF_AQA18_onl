package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final By checkoutButton = By.id("checkout");

    public SelenideElement getCheckoutButton () {
        return $(checkoutButton);
    }
}
