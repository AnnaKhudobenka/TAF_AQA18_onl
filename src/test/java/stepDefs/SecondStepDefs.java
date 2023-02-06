package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class SecondStepDefs extends BaseCucumberTest {
    protected BaseCucumberTest baseCucumberTest;

    public SecondStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Then("открыть страницу настроек")
    public void openSetupPage() {
        driver.get(ReadProperties.getUrl() + "index.php?/admin/overview");
    }

}
