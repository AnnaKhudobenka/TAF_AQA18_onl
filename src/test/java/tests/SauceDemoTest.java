package tests;

import baseEntities.BaseTestHW;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTestHW {

    @Test
    public void sauceDemoTest() throws InterruptedException {

        Assert.assertTrue(userStepsHW.login("standard_user", "secret_sauce").isPageOpened());
        Assert.assertTrue(userStepsHW.addProductAndGoToCart().isPageOpened());
        userStepsHW.putCheckoutButton();
        Assert.assertTrue(userStepsHW.putYourPayInfo("Ivan", "Ivanov", "11111").isPageOpened());
        userStepsHW.finishPayment();
        Thread.sleep(3000);
    }
}
