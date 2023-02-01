package stepDefs;

import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import steps.UserSteps;

public class FirstStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("открыт браузер")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("страница логина открыта")
    @When("дубликат шага")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
        loginPage = new LoginPage(driver);
    }

    @Then("поле username отображается")
    public void isUsernameDisplayed() {
        Assert.assertTrue
                (loginPage.getEmailInput().isDisplayed());
    }

    @Then("поле password отображается")
    public void isPasswordDisplayed() {
        Assert.assertTrue
                (loginPage.getPassword().isDisplayed());
    }

    @But("ошибка не отображается")
    public void isErrorDisplayed() {
        Assert.assertFalse
                (loginPage.getErrorTextElement().isDisplayed());
    }

    @Given("user {string} with password {string} logged in")
    public void userWithPasswordLogin(String username, String password) {
        UserSteps userSteps = new UserSteps(driver);
        userSteps.loginSuccessful(username, password);
         }

    @Then("title is {string}")
    public void title(String value) {
        Assert.assertEquals(value, dashboardPage.getTitle());
    }

    @And("project id is 123")
    public void id(String value) {
        Assert.assertEquals(value, 123);
    }
 }
