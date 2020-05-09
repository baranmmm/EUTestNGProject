package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelecetDropdown {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");



        driver.findElement(By.id("dropdownMenuLink")).click();
        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        for (WebElement Option : dropdownOptions) {

            System.out.println(Option.getText());

        }

        dropdownOptions.get(2).click();




    }
}
