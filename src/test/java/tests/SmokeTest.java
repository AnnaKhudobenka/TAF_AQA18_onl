package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void validateIKTCalculator() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");

        WebElement heightInput = driver.findElement(By.name("height"));
        WebElement weightInput = driver.findElement(By.name("weight"));
        WebElement calcButton = driver.findElement(By.id("calc-mass-c"));

        heightInput.sendKeys("183");
        weightInput.sendKeys("58");
        calcButton.click();

        Thread.sleep(3000);

        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(),
                "17.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKFTest() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select select = new Select(selectWebElement);
//        select.selectByIndex(1);
//        Thread.sleep(2000);
//        select.selectByValue("0");
//        Thread.sleep(2000);
        select.selectByVisibleText("женский");
        Thread.sleep(2000);

        driver.findElement(By.id("oCr")).sendKeys(("80"));
        driver.findElement(By.id("oAge")).sendKeys(("38"));
        driver.findElement(By.id("oWeight")).sendKeys(("55"));
        driver.findElement(By.id("oHeight")).sendKeys(("163"));
        driver.findElement(By.cssSelector("[type='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtMDRD")).getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        Assert.assertEquals(driver.findElement(By.id("txtMDRD1")).getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");
        Assert.assertEquals(driver.findElement(By.id("txtCG")).getText(), "Cockroft-Gault: 70 (мл/мин)");
        Assert.assertEquals(driver.findElement(By.id("txtBSA")).getText(), "Поверхность тела:1.58 (кв.м)");

    }

    @Test
    public void validateElectricCalTest() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement selectWebElement = driver.findElement(By.id("room_type"));
        Select select = new Select(selectWebElement);
        select.selectByValue("3");
        Thread.sleep(1000);

        WebElement selectWebElement2 = driver.findElement(By.id("heating_type"));
        Select select2 = new Select(selectWebElement2);
        select2.selectByValue("3");
        Thread.sleep(1000);

        driver.findElement(By.id("el_f_width")).sendKeys("3");
        driver.findElement(By.id("el_f_lenght")).sendKeys("5");
        driver.findElement(By.id("el_f_losses")).sendKeys("1000");
        driver.findElement(By.cssSelector("[type='button']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getText(), "557");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getText(), "37");
    }

    @Test
    public void validateLaminateCalTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        WebElement webElement = driver.findElement(By.id("laying_method_laminate"));
        Select select = new Select(webElement);
        select.selectByValue("2");

        driver.findElement(By.id("ln_room_id")).clear();
        driver.findElement(By.id("ln_room_id")).sendKeys("500");
        driver.findElement(By.id("wd_room_id")).clear();
        driver.findElement(By.id("wd_room_id")).sendKeys("400");
        driver.findElement(By.id("ln_lam_id")).clear();
        driver.findElement(By.id("ln_lam_id")).sendKeys("2000");
        driver.findElement(By.id("wd_lam_id")).clear();
        driver.findElement(By.id("wd_lam_id")).sendKeys("200");
        driver.findElement(By.id("direction-laminate-id1")).click();
        driver.findElement(By.className("calc-btn")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.cssSelector("[style='padding:5px 0;font-size:22px; color:#C80303; font-weight:bold;']")).getText(), "53");
        Assert.assertEquals(driver.findElement(By.cssSelector("[style='padding:5px 0;font-size:18px; color:#0E8C19; font-weight:bold;']")).getText(), "7");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
