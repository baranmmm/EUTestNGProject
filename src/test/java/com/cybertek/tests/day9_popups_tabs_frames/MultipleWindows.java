package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @Test

    public void switchWindowTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Before switching the window the title is:" + driver.getTitle());

        driver.findElement(By.cssSelector("[href=\"/windows/new\"]")).click();
        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }


        }
        System.out.println("After switching the window the title is:"+ driver.getTitle());


    }

    @BeforeMethod
    public void beforeMethod(){

        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() {

        Sleeper.sleep(2);
        driver.quit();


    }

    @Test
    public void WindowChange(){

        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.findElement(By.xpath("//*[.=\"Click Here\"]")).click();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currentWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String Window : allWindows) {
            if(!currentWindow.equals(Window)){

                driver.switchTo().window(Window);
            }

        }
        System.out.println("driver.New = " + driver.getTitle());


    }
    @Test
    public void multipleWindowTest(){
        driver.get("http://practice.cybertekschool.com/windows");
        Sleeper.sleep(1);
        driver.findElement(By.xpath("//*[.=\"Click Here\"]")).click();
        System.out.println("Before switching: "+driver.getTitle());
        //String currentHandle = driver.getWindowHandle();

        Set<String> AllHandles = driver.getWindowHandles();

        for (String handle : AllHandles) {

            driver.switchTo().window(handle);
            if(driver.getTitle().equals("New Window")){
                break;
            }

        }

        System.out.println("After switching: "+driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        driver.get("http://google.com");


    }

    @Test
    public void iframeTest(){

        driver.get("http://practice.cybertekschool.com/iframe");
//        driver.switchTo().frame("mce_0_ifr");
//        WebElement textBox = driver.findElement(By.id("tinymce"));
//        textBox.clear();
//        textBox.sendKeys("Group-1");


//        driver.switchTo().frame("mce_0_ifr");
//        driver.findElement(By.xpath("//p")).clear();
//        driver.findElement(By.xpath("//p")).sendKeys("Mehmet BARAN");
//        Sleeper.sleep(1);
//
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(0);
//        driver.findElement(By.id("tinymce")).clear();
//        driver.findElement(By.id("tinymce")).sendKeys("Group-1");
//        Sleeper.sleep(1);
//
        driver.switchTo().parentFrame();


        WebElement iframe = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframe);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Group-1 Again");

    }

    @Test
    public void nestedFrames() {

        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        Sleeper.sleep(1);

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bottom = driver.findElement(By.tagName("body")).getText();
        System.out.println(bottom);


//        driver.switchTo().frame("frame-top");
//        driver.switchTo().frame(2);
//        System.out.println(driver.findElement(By.tagName("body")).getText());
//
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
//        driver.switchTo().frame("frame-bottom");
//        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
