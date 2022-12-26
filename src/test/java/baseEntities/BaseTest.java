package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;
import steps.UserSteps;

public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userStep;
    protected WaitsService waitsService;


    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
        driver.get(ReadProperties.getUrl());

        userStep = new UserSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
