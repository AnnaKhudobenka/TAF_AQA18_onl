package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final static String pagePath = "index.php?/dashboard";
    private final By headerError = By.id("ui-dialog-title-messageDialog");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver);

        if (openPageByUrl) {
            openPageByUrl();
        }
    }

    @Override
    protected By getPageIdentifier() {
        return headerError;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
