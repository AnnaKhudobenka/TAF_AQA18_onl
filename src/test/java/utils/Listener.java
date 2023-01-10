package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Make a screenshot...");
    }
}
