package com.cybertek.tests.day17_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest() {

        extentLogger=report.createTest("Wrong Password test");
        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter usernanme: user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password: someusername");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");
        extentLogger.info("Verify page url");

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/loginN");
        extentLogger.pass("PASS: Wrong password test");
    }

    @Test
    public void wrongUsernameTest() {

        extentLogger=report.createTest("Wrong username test");
        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter username: someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password: UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");
        extentLogger.info("Verify page url");

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
        extentLogger.pass("PASS: Wrong username test");
    }

}
