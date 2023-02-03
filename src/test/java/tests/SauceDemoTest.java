package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class SauceDemoTest extends BaseTest {

    @Test
    public void sauceDemoTest() {
        open("");

        userSteps.login(userForLogin);
        userSteps.addProductAndGoToCart();
        userSteps.putCheckoutButton();
        userSteps.putYourPayInfo(userForPay);
        userSteps.finishPayment();
        userSteps.check();
    }

}
