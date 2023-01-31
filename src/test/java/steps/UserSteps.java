package steps;

import pages.LoginPage;

public class UserSteps {
    private LoginPage loginPage;

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }
}
