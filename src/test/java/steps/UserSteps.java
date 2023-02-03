package steps;

import baseEntities.BaseStep;
import models.UserForLogin;
import models.UserForPay;

import static com.codeborne.selenide.Condition.visible;

public class UserSteps extends BaseStep {

    public void login(UserForLogin userForLogin) {
        loginPage.getUsernameInput().setValue(userForLogin.getUsername());
        loginPage.getPasswordInput().setValue(userForLogin.getPassword());
        loginPage.getLogInButton().click();
    }

    public void addProductAndGoToCart() {
        productsPage.getAddToCartTShirt().click();
        productsPage.getGoToCart().click();
    }

    public void putCheckoutButton() {
        cartPage.getCheckoutButton().click();
    }

    public void putYourPayInfo(UserForPay userForPay) {
        checkoutPage.getFirstName().sendKeys(userForPay.getFirstname());
        checkoutPage.getLastName().sendKeys(userForPay.getLastname());
        checkoutPage.getZipCode().sendKeys(userForPay.getZipcode());
        checkoutPage.getContinueButton().click();
    }

    public void finishPayment() {
        checkoutPage.getFinishButton().click();
        checkoutPage.getBackToProducts().click();
    }

    public void check() {
        productsPage.getHeaderTitleLabel().shouldBe(visible);
    }
}
