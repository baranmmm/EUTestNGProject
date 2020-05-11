package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.Sleeper;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @AfterMethod
    public void tearDown() {
        Sleeper.sleep(2);
        driver.quit();

    }

    @BeforeMethod
    public void setUp() {
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");


    }

    @Test
    public void printTable() {
        WebElement table=driver.findElement(By.id("table1"));
        System.out.println();
        Assert.assertTrue(table.getText().contains("fbach@yahoo.com"));

    }

    @Test
    public void testgetAllHeaders() {
        WebElement table=driver.findElement(By.id("table1"));
        List<WebElement> coloumns = driver.findElements(By.xpath("(//table)[1]//th"));
        System.out.println("coloumns.size() = " + coloumns.size());

        for (WebElement coloumn : coloumns) {
            System.out.println(coloumn.getText());

        }

    }

    @Test
    public void testPrintTableSize() {

        // number of coloumns
        List<WebElement> coloumns = driver.findElements(By.cssSelector("table#table1 th"));
        System.out.println("coloumns.size() = " + coloumns.size());

        // number of rows with header
        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("(//table)[1]//tr"));
        System.out.println("rowsWithHeader.size() = " + rowsWithHeader.size());

        // number of rows without header

        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("(//table)[1]/tbody/tr"));
        System.out.println("rowsWithoutHeader.size() = " + rowsWithoutHeader.size());

    }

    @Test
    public void testgetAllCellInOneRow() {
        List<WebElement> firstRow = driver.findElements(By.xpath("((//tbody)[1]/tr)[1]/td"));

        for (WebElement webElement : firstRow) {
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void testGetOneCell() {
        System.out.println(driver.findElement(By.xpath("((//tbody)[1]/tr)[1]/td[5]")).getText());
    }

    @Test
    public void testPrintAllAsATable() {
        List<WebElement> rows = driver.findElements(By.xpath("(//tbody)[1]/tr"));
        List<WebElement> coloumns = driver.findElements(By.xpath("(//tbody)[1]/tr[1]/td"));



        for (int i = 1; i <=rows.size() ; i++) {

            for (int j = 1; j <=coloumns.size() ; j++) {

                String data = driver.findElement(By.xpath("(//tbody)[1]/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(data+"     \t\t");

            }
            System.out.println();

        }
    }

    @Test
    public void testGetRow() {
        // print the first row information



        System.out.println(driver.findElement(By.xpath("(//table)[1]/tbody/tr[1]")).getText());


    }

    @Test
    public WebElement testHomework(int rowNumber, int colNumber) {

        WebElement data = driver.findElement(By.xpath("(//tbody)[1]/tr[" + rowNumber + "]/td[" + colNumber + "]"));


        return data;
    }


}
