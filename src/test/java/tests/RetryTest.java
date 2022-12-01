package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import unils.Retry;
import unils.Retry1;

public class RetryTest extends BaseTest {
    private int attempt = 1;

    @Test (retryAnalyzer = Retry1.class)
    public void flakyTest() {
        if (attempt == 3) {
            Assert.assertTrue(true);
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }
}
