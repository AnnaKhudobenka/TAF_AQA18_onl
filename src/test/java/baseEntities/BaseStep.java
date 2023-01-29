package baseEntities;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public class BaseStep {
    protected WebDriver driver;
    protected WaitsService waitsService;
    protected Logger userLogger = LogManager.getLogger("SauceDemo Test");

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        waitsService = new WaitsService(driver);
    }
}
