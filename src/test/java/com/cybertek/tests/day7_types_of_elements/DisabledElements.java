package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class DisabledElements {

    @BeforeClass

        public WebDriver settUp(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        return driver;
    }

    @Test
    public void test(){

        WebDriver driver=settUp();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement greenRadioButton= driver.findElement(By.id("green"));
        System.out.println("Is element enabled:"+ greenRadioButton.isEnabled());
        Assert.assertFalse(!greenRadioButton.isEnabled(), "Verify Green is not enabled");

    }

    @Test
    public void test2(){
        WebDriver driver=settUp();
        driver.get("https://google.com");
    }





}
