package com.cybertek.tests.VyTrack.US01_TruckDriver_Vehicles;


import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;

import com.github.javafaker.Faker;
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
    public void testCase052() throws IOException, InterruptedException {
        Actions actions=new Actions(driver);

        WebElement fleet=driver.findElement(By.xpath("(//span[contains(text(), \"Fleet\")])[1]"));
        actions.moveToElement(fleet).build().perform();

        WebElement vehicles=driver.findElement(By.xpath("(//*[.=\"Vehicles\"])[2]"));
        actions.moveToElement(vehicles).click(vehicles).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//td[.=\"Miss Sherman Jenkins\"]"))).build().perform();
        Thread.sleep(1000);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        Thread.sleep(200);
        for (int i = 0; i <10 ; i++) {
            jse.executeScript("window.scrollBy(0,250);");
        }


//
//        String Cars = driver.findElement(By.xpath("//*[.=\"Cars\"]")).getText();
//
//
//        Assert.assertEquals(Cars, "Cars");



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
        Faker fk= new Faker();


        //Hovering over Fleet
        WebElement fleet=driver.findElement(By.xpath("(//span[contains(text(), \"Fleet\")])[1]"));
        actions.moveToElement(fleet).build().perform();

        //Selecting Vehicles
        WebElement vehicles=driver.findElement(By.xpath("(//*[.=\"Vehicles\"])[2]"));
        actions.moveToElement(vehicles).click(vehicles).build().perform();



        //Selecting any car
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[.=\"47KE7769\"]")))).click();


        //Clicking on Add Event button
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-id=\"2475\"]"))));
        Sleeper.sleep(1);
        driver.findElement(By.xpath("//a[@data-id=\"2475\"]")).click();

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
        Sleeper.sleep(1);
        driver.findElement(By.cssSelector("[data-name=\"field__use-hangout\"]")).click();

        //Selecting some context
        actions.moveToElement(driver.findElement(By.xpath("(//ul[@class=\"select2-choices\"])[2]/li[2]"))).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), \"(Vehicle Services Logs)\")]")))).click();

        //Selecting Owner to event

        driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]")).click();

        driver.findElement(By.xpath("//div[@class=\"select2-search\"]/input")).sendKeys("Store Manager");
        Sleeper.sleep(4);
        driver.findElement(By.xpath("//div[@class=\"select2-search\"]/input")).sendKeys(Keys.ENTER);

        //Writing of any name to Organizer display name textbox

        String name=fk.name().fullName();
        driver.findElement(By.name("oro_calendar_event_form[organizerDisplayName]")).sendKeys(name);

        //Writing of any email to Organizer email textbox

        String email=fk.internet().emailAddress();
        driver.findElement(By.name("oro_calendar_event_form[organizerEmail]")).sendKeys(email);

        //Choosing all day checkbox
        driver.findElement(By.xpath("//input[@name=\"oro_calendar_event_form[allDay]\"]")).click();
        Sleeper.sleep(1);
        driver.findElement(By.xpath("//input[@name=\"oro_calendar_event_form[allDay]\"]")).click();

        //Choosing a start date
        driver.findElement(By.xpath("(//input[@placeholder=\"Choose a date\"])[1]")).click();
        Sleeper.sleep(1);
        driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//td[.=\"20\"]")).click();

        //Choosing a start time
        driver.findElement(By.xpath("(//input[@placeholder=\"time\"])[1]")).click();
        driver.findElement(By.xpath("//li[@class=\"ui-timepicker-pm\"][contains(text(), \"3:30 PM\")]")).click();

        //Choosing an end date
        driver.findElement(By.xpath("(//input[@placeholder=\"Choose a date\"])[2]")).click();
        Sleeper.sleep(1);
        driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//td[.=\"20\"]")).click();

        //Choosing an end time
        driver.findElement(By.xpath("(//input[@placeholder=\"time\"])[2]")).click();
        driver.findElement(By.xpath("(//li[@class=\"ui-timepicker-pm\"][contains(text(), \"5:00 PM\")])[2]")).click();

        //Choosing recurrence checkbox
        driver.findElement(By.cssSelector("[data-name=\"recurrence-repeat\"]")).click();

        //Choosing recurrence sequence
        Select select1=new Select(driver.findElement(By.cssSelector("[data-name=\"recurrence-repeats\"]")));
        select1.selectByVisibleText("Monthly");

        //Choosing repetance time
        driver.findElement(By.xpath("//span[.=\"month(s)\"]/../input")).clear();
        driver.findElement(By.xpath("//span[.=\"month(s)\"]/../input")).sendKeys("2");

        //Selecting repetance on
        Select select2=new Select(driver.findElement(By.xpath("(//select[@data-related-field=\"instance\"])[1]")));
        select2.selectByVisibleText("Second");
        Select select3=new Select(driver.findElement(By.xpath("(//span//select[@data-related-field=\"dayOfWeek\"])[1]")));
        select3.selectByVisibleText("Weekday");

        //Selecting Ends radio button
        driver.findElement(By.xpath("//span[.=\"After\"]/../input[@type=\"radio\"]")).click();

        //Writing of 10 to occurrence textbox
        driver.findElement(By.xpath("//span[.=\"occurrences\"]/../input[@type=\"text\"]")).sendKeys("10");

        //Saving of event
        driver.findElement(By.xpath("//button[.=\"Save\"]")).click();





















    }


}
