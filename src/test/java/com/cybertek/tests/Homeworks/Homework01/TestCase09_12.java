package com.cybertek.tests.Homeworks.Homework01;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase09_12 {

    WebDriver driver;

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(1);
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testCase09() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/status_codes\"]")).click();
        driver.findElement(By.cssSelector("[href=\"status_codes/200\"]")).click();
        String Message = driver.findElement(By.xpath("//*[contains(text(), \"    This page returned a 200 status code.\")]")).getText();
        String Message2=Message.substring(0, Message.indexOf('.'));
        String expectedMessage="This page returned a 200 status code";

        Assert.assertEquals(Message2, expectedMessage);

    }

    @Test
    public void testCase10() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/status_codes\"]")).click();
        driver.findElement(By.cssSelector("[href=\"status_codes/301\"]")).click();
        String Message = driver.findElement(By.xpath("//*[contains(text(), \"    This page returned a 301 status code.\")]")).getText();
        String Message2=Message.substring(0, Message.indexOf('.'));
        String expectedMessage="This page returned a 301 status code";

        Assert.assertEquals(Message2, expectedMessage);
    }

    @Test
    public void testCase11() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/status_codes\"]")).click();
        driver.findElement(By.cssSelector("[href=\"status_codes/404\"]")).click();
        String Message = driver.findElement(By.xpath("//*[contains(text(), \"    This page returned a 404 status code.\")]")).getText();
        String Message2=Message.substring(0, Message.indexOf('.'));
        String expectedMessage="This page returned a 404 status code";

        Assert.assertEquals(Message2, expectedMessage);
    }

    @Test
    public void testCase12() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/status_codes\"]")).click();
        driver.findElement(By.cssSelector("[href=\"status_codes/500\"]")).click();
        String Message = driver.findElement(By.xpath("//*[contains(text(), \"    This page returned a 500 status code.\")]")).getText();
        String Message2=Message.substring(0, Message.indexOf('.'));
        String expectedMessage="This page returned a 500 status code";

        Assert.assertEquals(Message2, expectedMessage);
    }




}
