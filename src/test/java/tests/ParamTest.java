package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
    Calculator calculator = new Calculator();

    @Parameters({"login-value", "psw-value"})
    @Test
    public void paramTest(@Optional("default_user") String log,
                          @Optional("123") String psw) {
        System.out.println("Login is: " + log);
        System.out.println("Psw is: " + psw);
    }

    @Parameters({"first-num", "second-num"})
    @Test
    public void paramDivTest(@Optional("14") String first, @Optional("7") String second) {
        int a = Integer.parseInt(first);
        int b = Integer.parseInt(second);
        Assert.assertEquals(calculator.div(a, b), 2,
                "Ошибка при делении");
    }
}
