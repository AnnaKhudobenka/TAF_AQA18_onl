package stepDefs;

import baseEntities.BaseCucumberTest;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BaseCucumberTest {
    protected BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before
    public void initScenario(Scenario scenario) {
        System.out.println("HOOK: Started browser");

        baseCucumberTest.driver = new BrowserFactory().getDriver();
    }

    @After
    public void completeScenario(Scenario scenario) {
        if (baseCucumberTest.driver != null) {
            baseCucumberTest.driver.quit();
        }
    }
}
