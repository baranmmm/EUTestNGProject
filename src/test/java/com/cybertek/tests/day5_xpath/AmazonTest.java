package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
        String result1=driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();
        String result2=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        System.out.println(result1+" "+result2);
        driver.quit();

    }

}
