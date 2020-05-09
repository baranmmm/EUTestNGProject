package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DisplayTestDemo {




    @Test
    public void test1() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement usernameInput=driver.findElement(By.id("username"));
        Assert.assertFalse(usernameInput.isDisplayed());
        driver.findElement(By.xpath("//button[.=\"Start\"]")).click();
        Thread.sleep(5000);
        Assert.assertTrue(usernameInput.isDisplayed());


        driver.quit();


    }
}
