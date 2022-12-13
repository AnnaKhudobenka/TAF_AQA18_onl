package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;

    public UserSteps(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
    }

    public void login(String email, String password) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage. getLogInButton().click();
    }

    public DashboardPage loginSuccessful(String email, String password) {
        login(email, password);

        return new DashboardPage(driver);
    }

     public LoginPage loginInCorrect(String email, String password) {
         login(email, password);

         return loginPage;
     }

}
