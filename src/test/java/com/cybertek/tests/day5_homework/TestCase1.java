package com.cybertek.tests.day5_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TestCase1 {

    public static void main(String[] args) {

        WebDriver driver=new WebDriverFactory().getDriver("chrome");
        driver.get("https://amazon.co.uk");
        driver.quit();



    }

}
