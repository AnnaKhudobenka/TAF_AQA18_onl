package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends BaseTest{

    Calculator calculator = new Calculator();

    @Test(groups = "simpleAction")
    public void testDiv () {
        Assert.assertEquals(calculator.div(8, 4), 2,
                "Ошибка при делении");
    }
    @Test (description = "Тест с описанием", dependsOnMethods = "testDiv", groups = "simpleAction")
    public void testDivWithDescription () {
        Assert.assertEquals(calculator.div(8, 4), 2,
                "Ошибка при делении");
    }
    @Test (testName = "Деление целых чисел", invocationCount = 3, invocationTimeOut = 1000, groups = "simpleAction")
    public void testDivWithName () {
        Assert.assertEquals(calculator.div(8, 4), 2,
                "Ошибка при делении");
    }
    @Test (expectedExceptions = ArithmeticException.class, groups = "nullAction", priority = 3)
    public void testDivIntWithNull () {
        Assert.assertEquals(calculator.div(8, 0), 0,
                "Деление на ноль запрещено");
    }
    @Test (expectedExceptions = ArithmeticException.class, groups = "nullAction", priority = 2)
    public void testDivIntWithNull2 () {
        Assert.assertEquals(calculator.div(0, 0), 0,
                "Деление на ноль запрещено");
    }
    @Test(groups = "nullAction", priority = 1)
    public void testDivIntWithNull3 () {
        Assert.assertEquals(calculator.div(0, 2), 0,
                "Ошибка при делении");
    }
    @Test(groups = "nullAction")
    public void testDivDoubleWithNull () {
        Assert.assertEquals(calculator.div(8.0, 0), Double.POSITIVE_INFINITY);
    }
    @Test(groups = "nullAction")
    public void testDivDoubleWithNull2 () {
        Assert.assertEquals(calculator.div(-8.0, 0), Double.NEGATIVE_INFINITY);
    }
    @Test(groups = "nullAction")
    public void testDivDoubleWithNull3 () {
        Assert.assertEquals(calculator.div(0, 0.0), Double.NaN);
    }

}
