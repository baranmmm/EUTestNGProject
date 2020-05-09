package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1(){

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement=driver.findElement(By.id("state"));
        Select stateDropdown= new Select(dropdownElement);
        List<WebElement> options = stateDropdown.getOptions();

        for (WebElement option : options) {

            System.out.println(option.getText());
        }


    }
}
