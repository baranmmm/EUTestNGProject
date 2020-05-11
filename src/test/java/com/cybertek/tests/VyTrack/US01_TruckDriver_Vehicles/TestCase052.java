package com.cybertek.tests.VyTrack.US01_TruckDriver_Vehicles;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCase052 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.findElement(By.xpath("(//button[@data-dismiss=\"alert\"])[1]")).click();
        Sleeper.sleep(2);
        driver.findElement(By.xpath("(//button[@data-dismiss=\"alert\"])[1]")).click();


    }

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(2);
        driver.quit();
    }

    @Test
    public void testCase052() throws IOException {
        Actions actions=new Actions(driver);

        WebElement fleet=driver.findElement(By.xpath("(//span[contains(text(), \"Fleet\")])[1]"));
        actions.moveToElement(fleet).build().perform();

        WebElement vehicles=driver.findElement(By.xpath("(//*[.=\"Vehicles\"])[2]"));
        actions.moveToElement(vehicles).click(vehicles).build().perform();


        String Cars = driver.findElement(By.xpath("//*[.=\"Cars\"]")).getText();


        Assert.assertEquals(Cars, "Cars");



    }

    @Test
    public void testCase055() {


        String info = driver.findElement(By.xpath("//span[.=\"General Information\"]")).getText();

        Assert.assertEquals(info, "General Information");


    }

    @Test
    public void testCase066() {
        Actions actions=new Actions(driver);

        WebElement fleet=driver.findElement(By.xpath("(//span[contains(text(), \"Fleet\")])[1]"));
        actions.moveToElement(fleet).build().perform();

        WebElement vehicles=driver.findElement(By.xpath("(//*[.=\"Vehicles\"])[2]"));
        actions.moveToElement(vehicles).click(vehicles).build().perform();
        Sleeper.sleep(2);

        //driver.findElement(By.xpath("//*[.=\"47KE7769\"]")).click();
        //driver.findElement(By.cssSelector("[data-id=\"2475\"]")).click();
        //driver.findElement(By.id("oro_calendar_event_form_title-uid-5eb8d1a88496e")).sendKeys("Car Maintenance Planning Meeting");


    }
}
