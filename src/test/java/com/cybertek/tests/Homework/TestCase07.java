package com.cybertek.tests.Homework;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase07 {

    WebDriver driver;

    @Test
    public void testCase07() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/upload\"]")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\BARAN\\Desktop\\hello.txt");
        driver.findElement(By.id("file-submit")).click();
        String expectedSubject="File Uploaded!";
        String actualSubject = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(actualSubject,expectedSubject);

        String expectedUploadedFile="hello.txt";
        String actualUploadedFile = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("expectedUploadedFile = " + expectedUploadedFile);
        System.out.println("actualUploadedFile = " + actualUploadedFile);

        boolean displayed = driver.findElement(By.id("uploaded-files")).isDisplayed();
        Assert.assertTrue(displayed, "Verifying file name is displayed or not");


    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(2);
        driver.quit();
    }
}
