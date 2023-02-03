package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private  final By headerTitleLabel = By.xpath("//span[contains(text(), 'Products')]");

    private  final By addToCartTShirt = By.xpath("//div[text()='49.99']/following-sibling::button");

    private  final By goToCart = By.className("shopping_cart_link");

    public SelenideElement getHeaderTitleLabel() { return $(headerTitleLabel);}
    public SelenideElement getAddToCartTShirt() { return $(addToCartTShirt);}
    public SelenideElement getGoToCart() { return $(goToCart);}
}
