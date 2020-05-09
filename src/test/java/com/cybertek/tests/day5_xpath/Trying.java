package com.cybertek.tests.day5_xpath;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trying {

    public static void main(String[] args) throws InterruptedException {





            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.get("https://amazon.co.uk");
            driver.findElement(By.xpath("(//a[@href=\"/gp/video/primesignup/ref=dvm_crs_gat_uk_xs_s_dk_hud_eg_u_2\"])[2]")).click();



        driver.close();


    }
}
