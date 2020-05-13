package com.cybertek.tests.day12_actions_jsExecutor;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @AfterMethod
    public void tearDown() {
        //Sleeper.sleep(2);
        //driver.quit();
    }

    @BeforeMethod
    public void setUp() {
       driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();



    }

    @Test
    public void clickWithJS() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.cssSelector("[href=\"/dropdown\"]"));


        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdownLink);

    }
    @Test
    public void typingWithJS() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement disabledTextbox = driver.findElement(By.cssSelector("[style=\"width: 30%;\"]"));


        JavascriptExecutor jse= (JavascriptExecutor) driver;

        String str="Disabled textbox";
        jse.executeScript("arguments[0].value='"+str+"';", disabledTextbox);

    }

    @Test
    public void testScroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        for (int i = 0; i <100 ; i++) {
            Thread.sleep(50);
            jse.executeScript("window.scrollBy(0,250);");
        }
        for (int i = 0; i <80 ; i++) {
            Thread.sleep(1);
            jse.executeScript("window.scrollBy(0,-250);");
        }

    }

    @Test
    public void scrollDownandUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        for (int i = 0; i < 100; i++) {
            Thread.sleep(50);
            jse.executeScript("window.scrollBy(0, 250);");

        }

        for (int i = 0; i < 100; i++) {
            //Thread.sleep(1);
            jse.executeScript("window.scrollBy(0, -250);");

        }
    }

    @Test
    public void testScrollDown() throws InterruptedException {
        driver.get("https://scrollmagic.io/examples/advanced/infinite_scrolling.html");
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement loader = driver.findElement(By.id("loader"));

        for (int i = 0; i <100 ; i++) {
            //Thread.sleep(2000);
            //wait.until(ExpectedConditions.invisibilityOf(loader));
            jse.executeScript("window.scrollBy(0, 250);");
        }
    }
}
