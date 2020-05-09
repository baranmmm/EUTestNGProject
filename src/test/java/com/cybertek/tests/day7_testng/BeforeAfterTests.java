package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterTests {




    @Test
    public void test1(){
        System.out.println("This is my Test-1");

    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my Test-2");
    }

    @Test
    public void test3(){
        System.out.println("This is my Test-3");
    }

    @AfterMethod
    public void tearDown(){

        System.out.println("AFTER METHOD HERE");
        System.out.println("Quit Part");

    }

    @BeforeMethod
    public void setUp(){
        //WebDriver Part
        System.out.println("BEFORE METHOD HERE");
        System.out.println("Webdriver Part");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("BEFORE CLASS");

    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("AFTER CLASS");
    }
}
