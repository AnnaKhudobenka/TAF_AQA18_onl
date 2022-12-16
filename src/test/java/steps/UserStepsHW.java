package steps;

import baseEntities.BaseStepHW;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPageHW;
import pages.ProductsPage;

public class UserStepsHW extends BaseStepHW {
    private LoginPageHW loginPageHW;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public UserStepsHW(WebDriver driver) {
        super(driver);

        loginPageHW = new LoginPageHW(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public ProductsPage login(String username, String password) {
        loginPageHW.getUsernameInput().sendKeys(username);
        loginPageHW.getPasswordInput().sendKeys(password);
        loginPageHW.getLogInButton().click();
        return new ProductsPage(driver);
    }

    public CartPage addProductAndGoToCart() throws InterruptedException {
        productsPage.getAddToCartTShirt().click();
        productsPage.getGoToCart().click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }

    public void putCheckoutButton() {
        cartPage.getCheckoutButton().click();
    }

    public CheckoutPage putYourPayInfo(String firstname, String lastname, String zipcode) throws InterruptedException {
        checkoutPage.getFirstName().sendKeys(firstname);
        checkoutPage.getLastName().sendKeys(lastname);
        checkoutPage.getZipCode().sendKeys(zipcode);
        checkoutPage.getContinueButton().click();
        Thread.sleep(2000);
        return new CheckoutPage(driver);
    }
    public ProductsPage finishPayment() {
        checkoutPage.getFinishButton().click();
        checkoutPage.getBackToProducts().click();
        return new ProductsPage(driver);
    }

}
