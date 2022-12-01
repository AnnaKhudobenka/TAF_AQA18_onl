package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalTest extends BaseTest{

    @Test
    public void testSum() {
        Assert.assertEquals(calculator.sum(2, 3), 5,
                "Неверная сумма");
    }
    @Test
    public void testSum10() {
        Assert.assertEquals(calculator.sum(2, 3), 9,
                "Неверная сумма");
    }
    @Test(enabled = false)
    public void testSum1() {
        Assert.assertEquals(calculator.sum(2, 3), 5,
                "Неверная сумма");
    }
    @Test(description = "Тест с описанием")
    public void testSum2() {
        Assert.assertEquals(calculator.sum(2, 3), 5,
                "Неверная сумма");
    }
    @Test(testName = "Тест с названием")
    public void testSum3() {
        Assert.assertEquals(calculator.sum(2, 3), 5,
                "Неверная сумма");
    }
    @Test(timeOut = 1000) //время за которое должен пройти тест
    public void testSum4() throws InterruptedException {
        Thread.sleep(100);
    }
    @Test(invocationCount = 3) //повтор теста 3 раза последовательно
    public void testSum5() {
        Assert.assertEquals(calculator.sum(2, 3), 5,
                "Неверная сумма");
    }
    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    // threadPoolSize параллель повторений
    public void testSum6() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2, 3), 5,
                "Неверная сумма");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void exceptionTest() {
        List list = null;
        int size = list.size();
    }

}
