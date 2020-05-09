package com.cybertek.tests.Homework;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase01_05 {
    WebDriver driver;

    @Test
    public void testcase1() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/registration_form\"]")).click();

        WebElement notValidDob = driver.findElement(By.cssSelector("[data-bv-validator=\"date\"]"));

        Assert.assertFalse(notValidDob.isDisplayed(), "Verifying \"The date of birth is not valid\" message is NOT displayed");

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        Assert.assertTrue(notValidDob.isDisplayed(), "Verifying \"The date of birth is not valid\" message is NOT displayed");


    }

    @Test
    public void testcase2() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/registration_form\"]")).click();
        WebElement C = driver.findElement(By.xpath("//*[.=\"C++\"]"));
        WebElement Java = driver.findElement(By.xpath("//*[.=\"Java\"]"));
        WebElement JavaScript = driver.findElement(By.xpath("//*[.=\"JavaScript\"]"));

        Assert.assertTrue(C.isDisplayed(), "Verifying C++ is displayed on screen");
        Assert.assertTrue(Java.isDisplayed(), "Verifying Java is displayed on screen");
        Assert.assertTrue(JavaScript.isDisplayed(), "Verifying JavaScript is displayed on screen");
    }

    @Test
    public void testcase3() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/registration_form\"]")).click();
        WebElement nameWarning = driver.findElement(By.xpath("//small[contains(text(), \"first name must be more than 2\")]"));
        Assert.assertFalse(nameWarning.isDisplayed(),"Verifying name must be at least two characters warning is NOT displayed before entering any value");

        driver.findElement(By.name("firstname")).sendKeys("a");

        Assert.assertTrue(nameWarning.isDisplayed(),"Verifying name must be at least two characters warning is displayed after entering one character");


    }

    @Test
    public void testcase4() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/registration_form\"]")).click();
        WebElement lastnameWarning = driver.findElement(By.xpath("//small[contains(text(), \"The last name must be more than 2\")]"));
        Assert.assertFalse(lastnameWarning.isDisplayed(),"Verifying lastname must be at least two characters warning is NOT displayed before entering any value");

        driver.findElement(By.name("lastname")).sendKeys("a");

        Assert.assertTrue(lastnameWarning.isDisplayed(),"Verifying lastname must be at least two characters warning is displayed after entering one character");
    }

    @Test
    public void testcase5() {
        Faker fk=new Faker();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href=\"/registration_form\"]")).click();
        driver.findElement(By.name("firstname")).sendKeys(fk.name().firstName());
        Sleeper.sleep(1);
        driver.findElement(By.name("lastname")).sendKeys(fk.name().lastName());
        Sleeper.sleep(1);
        driver.findElement(By.name("username")).sendKeys("baranmmm");
        Sleeper.sleep(1);
        driver.findElement(By.name("email")).sendKeys(fk.internet().emailAddress());
        Sleeper.sleep(1);
        driver.findElement(By.name("password")).sendKeys("12345678");
        Sleeper.sleep(1);
        driver.findElement(By.name("phone")).sendKeys("555-555-5555");
        Sleeper.sleep(1);
        driver.findElement(By.cssSelector("[value=\"male\"]")).click();
        driver.findElement(By.name("birthday")).sendKeys("07/30/1984");
        Sleeper.sleep(1);
        WebElement department = driver.findElement(By.name("department"));

        Select sc=new Select(department);
        sc.selectByValue("DE");
        Sleeper.sleep(1);

        WebElement job_title = driver.findElement(By.name("job_title"));
        Select sc2=new Select(job_title);
        sc2.selectByVisibleText("SDET");
        Sleeper.sleep(1);

        driver.findElement(By.id("inlineCheckbox2")).click();
        Sleeper.sleep(1);

        driver.findElement(By.id("wooden_spoon")).click();
        String regisMessage = driver.findElement(By.xpath("//p")).getText();
        String expectedMessage= "You've successfully completed registration!";

        Assert.assertEquals(regisMessage,expectedMessage);



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
