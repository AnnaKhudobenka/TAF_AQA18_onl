package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private UIElement searchElement;
    private UIElement allElements;
    private List<UIElement> elementList;

    public DropDownMenu(WebDriver driver, String elementID) { // id "priority_id_chzn"
        UIElement uiElement = new UIElement(driver, By.id(elementID));
        uiElement.click();
        allElements = uiElement.findUIElement(By.className("chzn-results"));
        searchElement = uiElement.findUIElement(By.cssSelector("[type='text']"));

        elementList = new ArrayList<>();

        for (UIElement element : allElements.findUIElements(By.tagName("li"))) {
            elementList.add(element);
        }
    }

    public void selectByValue(int value) {
        elementList.get(value).click();
    }
    public void selectBySearch(String value) {
        searchElement.sendKeys(value);
    }
}
