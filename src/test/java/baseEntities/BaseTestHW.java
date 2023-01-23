package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;
import steps.UserSteps;
import java.time.Duration;

public class BaseTestHW {
    protected WebDriver driver;
    protected UserSteps userStepsHW;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected final static String pageLoginPath = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        driver.get(pageLoginPath);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        userStepsHW = new UserSteps(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
