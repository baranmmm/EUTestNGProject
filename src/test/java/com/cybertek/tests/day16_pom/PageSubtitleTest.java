package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void test1() {
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        BrowserUtils.waitFor(3);
        DashboardPage dashboardPage=new DashboardPage();
        String actualPageSubTitle = dashboardPage.getPageSubTitle();
        String expectedPageSubTitle="Quick Launchpad";

        Assert.assertEquals(actualPageSubTitle, expectedPageSubTitle, "verify subtitle");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(2);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        BrowserUtils.waitFor(2);
        String actualCalendarEventsPageSubtitle = calendarEventsPage.getPageSubTitle();
        String expectedCalendarEventsPageSubtitle="Calendar Events";
        Assert.assertEquals(actualCalendarEventsPageSubtitle,expectedCalendarEventsPageSubtitle);
    }

    @Test
    public void test2() {
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsSalesManager();
        BrowserUtils.waitFor(3);
    }

    @Test
    public void test3() {
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();
        BrowserUtils.waitFor(3);
    }
}
