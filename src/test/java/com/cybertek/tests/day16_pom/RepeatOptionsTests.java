package com.cybertek.tests.day16_pom;


import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class RepeatOptionsTests extends TestBase {

    /*VERIFY RADIO BUTTONS
Open browser
Login as driver
Go to Activities->Calendar Events
Click on create calendar events
Click on repeat
Verify that repeat every days is checked
verify that repeat weekday is not checked
* */

    @Test
    public void test1() {
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Select select=new Select(createCalendarEventsPage.repeatOptions);
        String actualDropdown = select.getFirstSelectedOption().getText();
        String expectedDropdown= "Daily";
        Assert.assertEquals(actualDropdown,expectedDropdown);

        boolean weekdayIsSelected = createCalendarEventsPage.weekday.isSelected();
        Assert.assertFalse(weekdayIsSelected);


    }

    @Test
    public void test2() {

    /*
    VERIFY REPEAT OPTIONS
    Open browser
    Login as driver
    Go to Activities->Calendar
    Click on create calendar events
    Click on repeat
    Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
    */
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsDriver();
        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        BrowserUtils.waitFor(3);
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Select select=new Select(createCalendarEventsPage.repeatOptions);
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());

        }



    }
}
