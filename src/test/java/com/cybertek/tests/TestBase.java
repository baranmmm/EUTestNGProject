package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Sleeper;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;
    public Faker faker;



    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver, 10);
        faker=new Faker();
        driver.get(ConfigurationReader.get("url"));





    }

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(2);
        Driver.closeDriver();
    }
}
