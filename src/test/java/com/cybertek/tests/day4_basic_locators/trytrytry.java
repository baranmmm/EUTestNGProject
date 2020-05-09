package com.cybertek.tests.day4_basic_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class trytrytry {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

//        System.out.println(driver.findElement(By.className("h3")).getText());
        driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger")).click();

    }
}
