package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPasswordInput().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();

//        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Projects')]")).isDisplayed());
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void loginSuccessfulTest() {
        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(),
                ReadProperties.password()).isPageOpened());
    }

    //@Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginInCorrect(ReadProperties.username(),
                "12345").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }
}
