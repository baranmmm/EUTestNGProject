package com.cybertek.tests.VyTrack.US01_TruckDriver_Vehicles;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


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
        driver.findElement(By.xpath("//button[@title=\"close\"]")).click();
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
        Actions actions=new Actions(driver);

        WebElement fleet=driver.findElement(By.xpath("(//span[contains(text(), \"Fleet\")])[1]"));
        actions.moveToElement(fleet).build().perform();

        WebElement vehicles=driver.findElement(By.xpath("(//*[.=\"Vehicles\"])[2]"));
        actions.moveToElement(vehicles).click(vehicles).build().perform();
        Sleeper.sleep(2);
        driver.findElement(By.xpath("//*[.=\"47KE7769\"]")).click();

        String info = driver.findElement(By.xpath("//span[.=\"General Information\"]")).getText();

        Assert.assertEquals(info, "General Information");


    }

    @Test
    public void testCase066() {
        Actions actions=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver, 10);


        //Hovering over Fleet
        WebElement fleet=driver.findElement(By.xpath("(//span[contains(text(), \"Fleet\")])[1]"));
        actions.moveToElement(fleet).build().perform();

        //Selecting Vehicles
        WebElement vehicles=driver.findElement(By.xpath("(//*[.=\"Vehicles\"])[2]"));
        actions.moveToElement(vehicles).click(vehicles).build().perform();



        //Selecting any car
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[.=\"47KE7769\"]")))).click();


        //Clicking on Add Event button
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-id=\"2475\"]")))).click();


        //Writing of "Car Maintenance Planning Meeting" to title textbox
        driver.findElement(By.name("oro_calendar_event_form[title]")).sendKeys("Car Maintenance Planning Meeting");

        //Writing of "We need to hold our car maintenance planning meeting as soon as possible" to Description textbox
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("tinymce")).sendKeys("We need to hold our car maintenance planning meeting as soon as possible");

        //Selecting a color to meeting
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("[style=\"color: #FFFFFF; background-color: #DC2127;\"]")).click();

        //Selecting some guests to meeting
        actions.moveToElement(driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"))).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[.=\"Truck Driver\"]")))).click();
        actions.moveToElement(driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"))).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[.=\"Store Manager\"]")))).click();
        actions.moveToElement(driver.findElement(By.xpath("(//input[@type=\"text\"])[3]"))).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[.=\"Vehicle Service\"]")))).click();

        //Clicking on +Add button
        driver.findElement(By.xpath("(//a[@href=\"javascript: void(0);\"])[4]")).click();

        //Writing of "2" to reminder textbox
        driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys("2");

        //Selecting hours from dropdown menu
        Select select=new Select(driver.findElement(By.xpath("(//select)[3]")));
        select.selectByVisibleText("hours");

        //Clicking on Call via Hangout checkbox
        driver.findElement(By.cssSelector("[data-name=\"field__use-hangout\"]")).click();

        //Selecting some context
        actions.moveToElement(driver.findElement(By.xpath("(//ul[@class=\"select2-choices\"])[2]/li[2]"))).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), \"(Vehicle Services Logs)\")]")))).click();

        //Scrolling down
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250);");


        //Selecting Owner to event

        //driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]")).click();

       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), \"Store Manager\")]/parent::*")))).click();
        //actions.moveToElement(driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]"))).click().build().perform();











    }
}
