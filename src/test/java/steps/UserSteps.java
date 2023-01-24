package steps;

import baseEntities.BaseStep;
import models.ProjectForLogin;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public UserSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void login(ProjectForLogin project) {
        loginPage.usernameInput.sendKeys(project.getUsername());
        loginPage.passwordInput.sendKeys(project.getPassword());
        loginPage.logInButton.click();
    }

    public void addProductAndGoToCart() {
        productsPage.addToCartTShirt.click();
        productsPage.goToCart.click();
    }

    public void putCheckoutButton() {
        cartPage.checkoutButton.click();
    }

    public void putYourPayInfo(User user) {
        checkoutPage.firstName.sendKeys(user.getFirstname());
        checkoutPage.lastName.sendKeys(user.getLastname());
        checkoutPage.zipCode.sendKeys(user.getZipcode());
        checkoutPage.continueButton.click();
    }
    public ProductsPage finishPayment() {
        checkoutPage.finishButton.click();
        checkoutPage.backToProducts.click();
        return new ProductsPage(driver);
    }

}
