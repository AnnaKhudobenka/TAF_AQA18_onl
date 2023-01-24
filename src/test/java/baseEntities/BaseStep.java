package baseEntities;

import models.User;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public class BaseStep {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        waitsService = new WaitsService(driver);
    }
}
