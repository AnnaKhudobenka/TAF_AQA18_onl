package tests.data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider (name = "dataForSum") // возвращает двумерный массив объектов
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {2, 3, 5},
                {0, 0, 0}
        };
    }
}
