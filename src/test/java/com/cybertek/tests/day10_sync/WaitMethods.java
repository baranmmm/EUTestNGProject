package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitMethods {
    WebDriver driver;

    @Test
    public void testWait() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        System.out.println(driver.findElement(By.id("finish")).getText());
    }

    @Test
    public void testWait2() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        WebElement hello = driver.findElement(By.id("finish"));
        WebDriverWait wait=new WebDriverWait(driver,10);
        String helloWorld = wait.until(ExpectedConditions.visibilityOf(hello)).getText();
        System.out.println(helloWorld);
    }



    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(2);
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
}
