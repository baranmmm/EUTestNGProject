package com.cybertek.tests.Homework;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase08 {
    WebDriver driver;

    @AfterMethod
    public void tearDown() {

        Sleeper.sleep(2);
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void testCase08() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/autocomplete\"]")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[value=\"Submit\"]")).click();

        String expectedMessage="You selected: United States of America";
        String actualMessage = driver.findElement(By.cssSelector("#result")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
