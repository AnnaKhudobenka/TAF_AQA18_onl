package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy (css = "[id$='name']")
    public WebElement usernameInput;
    @FindBy (css = "input[type$='rd']")
    public WebElement passwordInput;
    @FindBy (css = "div + input")
    public WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String showLoginMessage() {
        return "Massage about authorization";
    }

//    @Override
//    protected By getPageIdentifier() {
//        return logInButton;
//    }

}
