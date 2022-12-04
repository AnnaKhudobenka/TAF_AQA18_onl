package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

public class DataProviderTest {
    Calculator calculator = new Calculator();

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class)
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected,
                "Неверная сумма");
    }
    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class)
    public void testDiv(int a, int b) {
        int expected = calculator.div(a, b);
        Assert.assertEquals(calculator.div(a, b), expected,
                "Ошибка при делении");
    }
    @Test(dataProvider = "dataForDoubleDiv", dataProviderClass = StaticProvider.class)
    public void testDoubleDiv(double a, double b) {
        double expected = calculator.div(a, b);
        Assert.assertEquals(calculator.div(a, b), expected,
                "Ошибка при делении");
    }

}
