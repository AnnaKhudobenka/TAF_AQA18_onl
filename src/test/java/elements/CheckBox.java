package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        uiElement = new UIElement(driver, by);
    }

    public void removeFlag() {
        if (uiElement.isSelected()) {
            uiElement.click();
        }
    }
    public void putUpFlag() {
        if (!uiElement.isSelected()) {
            uiElement.click();
        }
    }

}
