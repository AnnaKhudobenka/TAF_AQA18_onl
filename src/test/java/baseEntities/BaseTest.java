package baseEntities;

import factory.BrowserFactory;
import models.ProjectForLogin;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;
import steps.UserSteps;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userSteps;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected final static String pageLoginPath = "https://www.saucedemo.com/";
    protected User user;
    protected ProjectForLogin project;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        driver.get(pageLoginPath);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        userSteps = new UserSteps(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        user = new User.Builder()
                .withFirstname("Ivan")
                .withLastname("Ivanov")
                .withZipcode("11111")
                .build();

        project = new ProjectForLogin();
        project.setUsername("standard_user");
        project.setPassword("secret_sauce");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
