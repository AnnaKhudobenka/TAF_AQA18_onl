package stepDefs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class UserStepDefs extends BaseCucumberTest {
    protected BaseCucumberTest baseCucumberTest;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;

    public UserStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;

    }

    @Given("открыта страница авторизации")
    public void openAuthorizationPage() {
        driver.get("https://www.saucedemo.com/");


    }
    @Then("пройдена авторизация пользователя {string} с паролем {string}")
    public void login(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLogInButton().click();
    }

    @Then("добавлен товар в корзину")
    public void addProductAndGoToCart() {
        productsPage = new ProductsPage(driver);
        productsPage.getAddToCartTShirt().click();
        productsPage.getGoToCart().click();
    }

    @Then("переход на страницу оплаты товара")
    public void putCheckoutButton() {
        cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
    }

    @Then("введены данные для оплаты: имя {string}, фамилия {string}, зипкод {string}")
    public void putYourPayInfo(String firstname, String lastname, String zipcode) {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.getFirstName().sendKeys(firstname);
        checkoutPage.getLastName().sendKeys(lastname);
        checkoutPage.getZipCode().sendKeys(zipcode);
        checkoutPage.getContinueButton().click();
    }

    @Then("завершена оплата товара и возвращение на главную станицу")
    public void finishPayment() {
        checkoutPage.getFinishButton().click();
        checkoutPage.getBackToProducts().click();
        productsPage.isPageOpened();
    }

}
