package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskHW_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }
    @AfterMethod
    public void turnDown() {
        driver.quit();
    }

    @Test
    public void taskTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("[id$='name']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[starts-with(@data-test, 'add-to-cart-sauce-labs-bolt')]")).click();
        driver.findElement(By.xpath("//div/a[1]")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//div/a/div")).getText(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, '_item_price')]")).getText(), "$15.99");
    }
}
