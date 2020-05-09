package com.cybertek.tests.day12_actions_jsExecutor;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {

    WebDriver driver;

    @Test
    public void testName() {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement image = driver.findElement(By.xpath("(//img)[1]"));
        WebElement image2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement image3 = driver.findElement(By.xpath("(//img)[3]"));


        Actions actions=new Actions(driver);

        actions.moveToElement(image).perform();
        actions.moveToElement(image2).perform();
        actions.moveToElement(image3).perform();
        actions.moveToElement(image2).perform();
        actions.moveToElement(image).perform();

    }

    @Test
    public void testDragAndDrop() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");


        Actions actions=new Actions(driver);
//        driver.findElement(By.cssSelector("[title=\"Accept Cookies\"]")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));


        actions.dragAndDrop(source, target).perform();

    }

    @Test
    public void testDragAndDropChaining() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");


        Actions actions=new Actions(driver);
//        driver.findElement(By.cssSelector("[title=\"Accept Cookies\"]")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //there are two ways to chaining, one of them is performing in one line
        //the other one is performing line by line
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

        actions.clickAndHold(source).perform();
        actions.moveToElement(target).perform();
        actions.release().perform();
    }

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(2);
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();


    }
}
