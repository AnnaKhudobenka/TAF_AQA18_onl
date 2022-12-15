package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
//    private WebDriver driver;
    // 1. блок описания локатора для элемента
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    // 2. блок инициализации стр

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    // 3. блок атомарных методов
    public WebElement getEmailInput() {
       return waitsService.waitForVisibilityBy(emailInputLocator);
    }
    public WebElement getPasswordInput() {
        return waitsService.waitForVisibilityBy(passwordInputLocator);
    }
    public WebElement getLogInButton() {
        return waitsService.waitForVisibilityBy(logInButtonLocator);
    }

    public WebElement getErrorTextElement() {
        return waitsService.waitForVisibilityBy(errorTextLocator); }
}
