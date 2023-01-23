package tests;

import baseEntities.BaseTestHW;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTestHW {

    @Test
    public void sauceDemoTest() throws InterruptedException {

        userStepsHW.login("standard_user", "secret_sauce");
        userStepsHW.addProductAndGoToCart();
        userStepsHW.putCheckoutButton();
        userStepsHW.putYourPayInfo("Ivan", "Ivanov", "11111");
        Assert.assertTrue(userStepsHW.finishPayment().isPageOpened());
        Thread.sleep(3000);
    }
}
