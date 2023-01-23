package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By usernameInputLocator = By.cssSelector("[id$='name']");
    private final By passwordInputLocator = By.cssSelector("input[type$='rd']");
    private final By logInButtonLocator = By.cssSelector("div + input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }

    public WebElement getUsernameInput() {
       return driver.findElement(usernameInputLocator);
    }
    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputLocator);
    }
    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }

}
