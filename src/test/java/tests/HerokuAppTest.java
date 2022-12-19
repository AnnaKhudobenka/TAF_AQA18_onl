package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.awt.*;
import java.time.Duration;

public class HerokuAppTest extends BaseTest {

    @Test
    public void contextMenuTest () throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(By.id("hot-spot"));
        actions.contextClick(webElement).perform();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        Thread.sleep(2000);
    }

    @Test
    public void dynamicControlsTest () {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        WaitsService waitsService = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement webElement1 =driver.findElement(By.id("checkbox"));
        Assert.assertTrue(webElement1.isDisplayed());
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebElement webElement = waitsService.waitForVisibilityBy(By.id("message"));
        Assert.assertTrue(webElement.isDisplayed());

        Assert.assertTrue(waitsService.waitForInvisible(webElement1));

        WebElement webElement2 = driver.findElement(By.xpath("//form/input"));
        Assert.assertFalse(webElement2.isEnabled());
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebElement webElement3 = waitsService.waitForVisibilityBy(By.id("message"));
        Assert.assertTrue(webElement3.isDisplayed());
        Assert.assertTrue(webElement2.isEnabled());
    }

    @Test
    public void fileUploaderTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement upload = waitsService.waitForExists(By.id("file-upload"));
        upload.sendKeys("C:\\Users\\HP\\IdeaProjects\\TestAuto\\src\\test\\resources\\picture.jpg");
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();

        WebElement file = waitsService.waitForVisibilityBy(By.id("uploaded-files"));
        Assert.assertEquals(file.getText(), "picture.jpg");
        Thread.sleep(2000);
    }

    @Test
    public void framesTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/frames");

        driver.findElement(By.xpath("//*[text()='iFrame']")).click();
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);

        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
    }
}
