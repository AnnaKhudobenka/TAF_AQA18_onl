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
        try {
            loginPage.usernameInput.sendKeys(project.getUsername());
            loginPage.passwordInput.sendKeys(project.getPassword());
            loginPage.logInButton.click();
        } catch (Exception e) {
            userLogger.error("Error with authorization");
            userLogger.fatal("Fatal error with authorization");
        }

        userLogger.info(loginPage.showLoginMessage());
    }

    public void addProductAndGoToCart() {
        try {
            productsPage.addToCartTShirt.click();
            productsPage.goToCart.click();
        } catch (Exception e) {
            userLogger.error("Error with add product and go to cart");
            userLogger.fatal("Fatal error with add product and go to cart");
        }
    }

    public void putCheckoutButton() {
        try {
            cartPage.checkoutButton.click();
        } catch (Exception e) {
            userLogger.error("Error with cart");;
            userLogger.fatal("Fatal error with cart");;
        }

        userLogger.info(cartPage.showCartMessage());
    }

    public void putYourPayInfo(User user) {
        try {
            checkoutPage.firstName.sendKeys(user.getFirstname());
            checkoutPage.lastName.sendKeys(user.getLastname());
            checkoutPage.zipCode.sendKeys(user.getZipcode());
            checkoutPage.continueButton.click();
        } catch (Exception e) {
            userLogger.error("Error with pay");
            userLogger.fatal("Fatal error with pay");
        }

        userLogger.info(checkoutPage.showCheckoutMessage());
    }

    public ProductsPage finishPayment() {
        try {
            checkoutPage.finishButton.click();
            checkoutPage.backToProducts.click();
        } catch (Exception e) {
            userLogger.error("Error with finish operation");
            userLogger.fatal("Fatal error with finish operation");
        }
        return new ProductsPage(driver);
    }
}
