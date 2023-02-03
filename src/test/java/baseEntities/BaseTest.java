package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import models.UserForLogin;
import models.UserForPay;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import steps.UserSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    protected final static String getPath = "https://www.saucedemo.com/";
    protected UserForLogin userForLogin;
    protected UserForPay userForPay;
    protected UserSteps userSteps;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected LoginPage loginPage;

    @BeforeSuite
    public void setUp() {
        loginPage = new LoginPage();
        userSteps = new UserSteps();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = getPath;
        Configuration.timeout = 15000;

        userForLogin = UserForLogin.builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();

        userForPay = UserForPay.builder()
                .lastname("Ivanov")
                .firstname("Ivan")
                .zipcode("11111")
                .build();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
