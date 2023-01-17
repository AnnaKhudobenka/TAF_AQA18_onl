package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;

    public UserSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    @Step
    public DashboardPage loginSuccessful(String email, String psw) {
        login(email, psw);

        return new DashboardPage(driver);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }
}
