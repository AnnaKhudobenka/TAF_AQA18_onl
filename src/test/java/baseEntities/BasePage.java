package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import services.WaitsService;

public abstract class BasePage extends BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        waitsService = new WaitsService(driver);

        PageFactory.initElements(driver, this);
    }

}

