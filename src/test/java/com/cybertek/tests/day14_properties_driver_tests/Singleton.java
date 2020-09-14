package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Singleton {

    @Test
    public void test1() {
        //WebDriver driver= Driver.get();
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }

    @Test
    public void test2() {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        //Driver.get().get("https://www.amazon.com");
    }
}
