package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtons {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement green = driver.findElement(By.id("green"));
        green.click();
        Thread.sleep(3000);

       Assert.assertFalse(green.isEnabled(), "Verify that green radio button is NOT enabled");

    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));

        for (int i = 0; i < 30; i++) {
             checkbox1.click();

        }


    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement state = driver.findElement(By.id("state"));

        Select stateDropdown=new Select(state);
        stateDropdown.selectByVisibleText("Louisiana");
        Thread.sleep(2000);

        stateDropdown.selectByIndex(5);
        Thread.sleep(2000);

        stateDropdown.selectByValue("MA");


//        List<WebElement> stateOptions = stateDropdown.getOptions();
//
//        for (WebElement stateOption : stateOptions) {
//
//            System.out.println(stateOption.getText());
//
//        }


    }

    @Test
    public void test4() {

        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.id("dropdownMenuLink")).click();
        List<WebElement> dropdownList = driver.findElements(By.cssSelector("[class=\"dropdown-item\"]"));
        dropdownList.get(0).click();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }
}
