package com.cybertek.tests.Homeworks.Homework01;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverOver {

    WebDriver driver;

    @AfterMethod
    public void tearDown() {
       Sleeper.sleep(2);
       driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void HoverOver() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");


        for (int i = 1; i <=3; i++) {

            //creating dynamic xpath for images
            String imgXpath = "(//img)["+i+"]";
            System.out.println(imgXpath);
            WebElement img = driver.findElement(By.xpath(imgXpath));

            Actions actions = new Actions(driver);

            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user"+i+"']";
            System.out.println(textXpath);
            WebElement text = driver.findElement(By.xpath(textXpath));

            Assert.assertTrue(text.isDisplayed(),"Verify user"+i+" is displayed");

        }

    }

    @Test
    public void testByMyself() {
//        driver.get("http://practice.cybertekschool.com/");
//        driver.findElement(By.linkText("Hovers")).click();
//        driver.findElement(By.)
//        Actions actions=new Actions(driver);
//        List<WebElement> images = driver.findElements(By.tagName("img"));
//        for (int i = 1; i <=images.size() ; i++) {
//            actions.moveToElement(driver.findElement(By.xpath("(//img)["+i+"]"))).perform();
//            String actual=driver.findElement(By.xpath("(//h5)[" + i + "]")).getText();
//            String name="name: user"+i;
//            Assert.assertTrue(actual.equals(name));
//        }


    }
}
