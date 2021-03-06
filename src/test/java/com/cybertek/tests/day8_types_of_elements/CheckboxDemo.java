package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1=driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[2]"));
        Assert.assertFalse(checkbox1.isSelected(), "Verify checkbox1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(), "Verify checkbox2 is selected");

        for (int i = 0; i < 30; i++) {
             checkbox1.click();

        }

        Thread.sleep(3000);




        driver.quit();
    }


}
