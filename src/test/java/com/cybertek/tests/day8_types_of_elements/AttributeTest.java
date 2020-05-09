package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {


    @Test
            public void test() throws InterruptedException {
   WebDriver driver=WebDriverFactory.getDriver("chrome");
   driver.get("http://practice.cybertekschool.com/multiple_buttons");
   WebElement button=driver.findElement(By.name("button2"));
        System.out.println("button.getText() = " + button.getText());
        System.out.println(button.getAttribute("outerHTML"));


    }



}
