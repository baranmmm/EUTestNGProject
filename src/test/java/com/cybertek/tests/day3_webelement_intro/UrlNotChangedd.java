package com.cybertek.tests.day3_webelement_intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlNotChangedd {
    public static void main(String[] args) {


//        open browser
//        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
//        enter any email
//        verify that email is displayed in the input box
//        click on Retrieve password
//        verify that confirmation message says 'Your e-mail's been sent!'


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        Faker fk=new Faker();
        String email=fk.internet().emailAddress();

        driver.findElement(By.name("email")).sendKeys(email);


        String actualEmail=driver.findElement(By.name("email")).getAttribute("value");


    }
}
