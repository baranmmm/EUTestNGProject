package com.cybertek.tests.Homework;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase06 {
    WebDriver driver;
    Faker fk=new Faker();

    @Test
    public void testCase06() {
        driver.get("https://www.fakemail.net/");
        String email=driver.findElement(By.xpath("//span[contains(text(), \"@\")]")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/sign_up\"]")).click();
        driver.findElement(By.name("full_name")).sendKeys(fk.name().firstName()+" "+fk.name().lastName());

        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("wooden_spoon")).click();
        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage=driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.get("https://www.fakemail.net/");



        String expectedMail="do-not-reply@practice.cybertekschool.com";
        String outerHTML=driver.findElement(By.xpath("(//span[@class=\"odMobil\"])[1]")).getAttribute("outerHTML");
        String outerHTML2=driver.findElement(By.xpath("(//span[@class=\"odMobil\"])[1]")).getText();
        System.out.println(outerHTML2);
        System.out.println(outerHTML);

        String []Mail=outerHTML.split(">");
        String actualMailBeforeClick=Mail[1].substring(0, Mail[1].indexOf('<'));

        Assert.assertEquals(expectedMail, actualMailBeforeClick);
        driver.findElement(By.xpath("(//*[contains(text(), \"do-not\")])[1]")).click();


        String actualMailAfterClick = driver.findElement(By.xpath("//*[@id=\"odesilatel\"]")).getText();
        Assert.assertEquals(expectedMail, actualMailAfterClick);

        String expectedThanksMessage="Thanks for subscribing to practice.cybertekschool.com!";
        String actualThanksMessage=driver.findElement(By.xpath("//*[@id=\"predmet\"]")).getText();
        Assert.assertEquals(expectedThanksMessage, actualThanksMessage);



    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(1);
        driver.quit();
    }
}
