package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.project.AddProjectPage;
import pages.project.AddTestCasePage;
import steps.NavigationSteps;

public class WrappersTest extends BaseTest {

    @Test
    public void checkBoxTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getCheckBox().putUpFlag();
    }

    @Test
    public void dropDownMenuTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddTestCasePage page = new NavigationSteps(driver).navigateToAddTestCasePage();

        page.getDropDown().selectByValue(1);
//        page.getDropDown().selectBySearch("High");
    }
}
