package com.cybertek.tests.day4_basic_locators;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IDLocatorTest {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("Mike Smith");

        Faker fk=new Faker();
        String email=fk.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("wooden_spoon")).click();

        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";

        String actualMessage=driver.findElement(By.name("signup_message")).getText();


        if(actualMessage.equalsIgnoreCase(expectedMessage)){

            System.out.println("PASS");

        }
        else {

            System.out.println("FAIL");
        }

        driver.quit();


    }
}
