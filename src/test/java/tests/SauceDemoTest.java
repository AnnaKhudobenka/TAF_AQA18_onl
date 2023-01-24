package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTest extends BaseTest {

    @Test
    public void sauceDemoTest() {
        userSteps.login(project);
        userSteps.addProductAndGoToCart();
        userSteps.putCheckoutButton();
        userSteps.putYourPayInfo(user);
        Assert.assertTrue(userSteps.finishPayment().isPageOpened());
    }
}
