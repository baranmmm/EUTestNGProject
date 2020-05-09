package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
         driver= WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void test1(){


        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[.=\"Destroy the World\"]")).click();
        driver.findElement(By.id("j_idt721:j_idt724")).click();

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.cssSelector("[onclick=\"jsPrompt()\"]")).click();


        Alert alert=driver.switchTo().alert();
        Thread.sleep(4000);
        alert.sendKeys("Mehmet Baran");
        alert.dismiss();
    }

    @Test
    public void testName() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.cssSelector("[onclick=\"jsAlert()\"]")).click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(1000);
        alert.dismiss();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[onclick=\"jsPrompt()\"]")).click();
        Thread.sleep(1000);
        alert.sendKeys("Group-1");
        alert.accept();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[onclick=\"jsPrompt()\"]")).click();
        System.out.println("alert.getText() = " + alert.getText());

    }

    @Test
    public void testNew(){

        driver.get("http://practice.cybertekschool.com/context_menu");
        Alert alert=driver.switchTo().alert();


    }
}
