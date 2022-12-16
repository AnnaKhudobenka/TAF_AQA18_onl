package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePageHW extends BaseTestHW{
    protected WebDriver driver;

    public BasePageHW(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

}

