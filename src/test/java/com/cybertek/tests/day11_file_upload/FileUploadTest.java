package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    WebDriver driver;



    @AfterMethod
    public void tearDown() {
        Sleeper.sleep((int) 0.5);
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\BARAN\\Desktop\\hello.txt");
        driver.findElement(By.id("file-submit")).click();
    }

    @Test
    public void test2() {
        String projectPath=System.getProperty("user.dir");
        //we get the directory of the intellij projects with this getProperty("user.dir") method.
        String relativePath="src\\test\\resources\\testFile.txt";
        //we get this relativePath from the menu, right click on testFile and copy from content root
        String absolutePath="C:\\Users\\BARAN\\IdeaProjects\\EU2TestNGProject\\src\\test\\resources\\testFile.txt";
        //we get this absolutePath from the menu, right click on testFile and copy absolute path
        String filePath=projectPath+"\\"+ relativePath;
        //we get this filePath by concatanating projectPath and relativePath, this is same with absolutePath.

        driver.get("http://practice.cybertekschool.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();

    }
}
