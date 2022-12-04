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
    @DataProvider (name = "dataForDiv")
    public static Object[][] dataForDivTest() {
        return new Object[][] {
                {-8, 2},
                {-8, -2},
                {8, 2}
        };
    }
    @DataProvider (name = "dataForDoubleDiv")
    public static Object[][] dataForDoubleDivTest() {
        return new Object[][] {
                {-8, 3.0},
                {-8, -3.0},
                {8, 3.0}
        };
    }

}
