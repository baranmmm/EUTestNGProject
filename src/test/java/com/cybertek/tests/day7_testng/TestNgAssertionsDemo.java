package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgAssertionsDemo {

    @Test
    public void test(){

        System.out.println("First Assertion");
        Assert.assertEquals("title", "tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        System.out.println("second test case");
        Assert.assertEquals("url", "url");
    }
}
