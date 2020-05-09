package com.cybertek.tests.day3_webelement_intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlChanged {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        String firstUrl=driver.getCurrentUrl();

        Faker fk=new Faker();
        String email=fk.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.id("form_submit")).click();
        String secondUrl=driver.getCurrentUrl();

        if(firstUrl.equalsIgnoreCase(secondUrl)){
            System.out.println("URL DOESN'T CHANGE");
        }
        else{
            System.out.println("URL CHANGED");
        }

        Thread.sleep(5000);
        driver.quit();







    }
}
