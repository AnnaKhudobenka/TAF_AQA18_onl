package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    private final By usernameInput = By.cssSelector("[id$='name']");
    private final By passwordInput = By.cssSelector("input[type$='rd']");
    private final By logInButton = By.cssSelector("div + input");

    public SelenideElement getUsernameInput() { return $(usernameInput);}
    public SelenideElement getPasswordInput() { return $(passwordInput);}
    public SelenideElement getLogInButton() { return $(logInButton);}
}
