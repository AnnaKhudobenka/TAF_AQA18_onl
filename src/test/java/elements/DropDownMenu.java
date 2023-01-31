package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownMenu {
    private UIElement uiElement;

    public DropDownMenu(WebDriver driver, By by) {
        uiElement = new UIElement(driver, by);
        uiElement.findUIElement(by);
        uiElement.click();
    }

    public void select(By by) {
        uiElement.findUIElement(by).click();
    }

}
