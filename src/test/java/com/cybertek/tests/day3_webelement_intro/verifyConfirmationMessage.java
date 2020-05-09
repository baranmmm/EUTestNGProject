package com.cybertek.tests.day3_webelement_intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyConfirmationMessage {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        Faker fk=new Faker();
        String email= fk.internet().emailAddress();

        WebElement inputBox=driver.findElement(By.name("email"));
        inputBox.sendKeys(email);
        driver.findElement(By.id("form_submit")).click();


        inputBox.getText();

        if(inputBox.getAttribute("value").equalsIgnoreCase(email)){
            System.out.println("PASS1");
        }else {
            System.out.println("FAIL1");
        }
        WebElement actulConfirmationMessage=driver.findElement(By.name("confirmation_message"));
        if(actulConfirmationMessage.getText().equalsIgnoreCase("Your e-mail's been sent!")){

            System.out.println("PASS2");
        }
        else {
            System.out.println("FAIL2");
        }




    }

}
