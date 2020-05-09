package com.cybertek.tests.day3_webelement_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlNotChanged {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        String firstUrl=driver.getCurrentUrl();
        driver.findElement(By.id("form_submit")).click();
        String secondUrl=driver.getCurrentUrl();

        if (firstUrl.equalsIgnoreCase(secondUrl)){

            System.out.println("URL DOESN'T CHANGE");
        }
        else {
            System.out.println("URL CHANGED");
        }

        driver.quit();

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://practice.cybertekschool.com/forgot_password");
//        String first = driver.getCurrentUrl();
//        driver.findElement(By.xpath("//*[@id=\'form_submit\']/i")).click();
//        String second = driver.getCurrentUrl();
//        if(first.equalsIgnoreCase(second)){
//            System.out.println("PASS");
//        }else
//            System.out.println("FAIL");
//        driver.quit();

    }
}
