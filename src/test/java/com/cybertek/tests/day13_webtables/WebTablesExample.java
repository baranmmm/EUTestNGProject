package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(2);
        driver.quit();

    }

    @BeforeMethod
    public void setUp() {
        driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @Test
    public void printTable() {
        WebElement table=driver.findElement(By.id("table1"));
        System.out.println();
        Assert.assertTrue(table.getText().contains("fbach@yahoo.com"));

    }


}
