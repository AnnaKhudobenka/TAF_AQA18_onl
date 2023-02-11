package pages.project;

import baseEntities.BasePage;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {

    private final static String pagePath = "index.php?/cases/add/12";

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public DropDownMenu getDropDown() {
        return new DropDownMenu(driver, "priority_id_chzn");
    }
}
