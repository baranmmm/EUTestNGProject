package com.cybertek.tests.Homeworks.Homework02;

import com.cybertek.pages.CalendarEventDetailsPage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework02 extends TestBase {


    public void storeManagerCalendarEvents(String testName){

        extentLogger=report.createTest(testName);
        LoginPage loginPage=new LoginPage();
        extentLogger.info("\"https://qa1.vytrack.com/\" is launced");
        loginPage.loginAsStoreManager();
        extentLogger.info("Logged in as a Store Manager");
        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage=new DashboardPage();
        BrowserUtils.waitFor(4);
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Navigate to \"Activities -> Calendar Events\"");
        BrowserUtils.waitFor(3);
    }


    @Test
    public void testCase01() {
        String testName="Verifying Option subtitle is displayed on screen";
        storeManagerCalendarEvents(testName);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        String actualSubtitleOptions = calendarEventsPage.subtitleOptions.getText();
        String expectedSubtitleOptions = "Options";

        Assert.assertEquals(actualSubtitleOptions, expectedSubtitleOptions, "Verify Options subtitle is displayed");
        extentLogger.pass("PASS: \"Options\" subtitle is displayed on screen");
    }

    @Test
    public void testCase02() {
        String testName="Verifying that page number is equals to \"1\"";
        storeManagerCalendarEvents(testName);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        String actualPageNumber = calendarEventsPage.pageNumber.getAttribute("value");
        String expectedPageNumber = "1";

        Assert.assertEquals(actualPageNumber, expectedPageNumber,"Verify that page number is equals to \"1\"");
        extentLogger.pass("PASS: Page Number is "+ expectedPageNumber);

    }

    @Test
    public void testCase03() {
        String testName="Verifying that \"View Per Page\" number is equals to \"25\"";
        storeManagerCalendarEvents(testName);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        String actualViewPerPageNumber = calendarEventsPage.viewPerPageNumber.getText();
        String expectedViewPerPageNumber="25";

        Assert.assertEquals(actualViewPerPageNumber,expectedViewPerPageNumber, "Verify that view per page number is equals to 25");
        extentLogger.pass("PASS: View Per Page number is "+ expectedViewPerPageNumber);

    }

    @Test
    public void testCase04() {
        String testName="Verifying number of calendar events is equals to number of records";
        storeManagerCalendarEvents(testName);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        String recordsMessage = calendarEventsPage.numberOfRecords.getText();
        System.out.println(recordsMessage);

        String[] recMessageArray = recordsMessage.split(" ");
        String numOfRecords=recMessageArray[2];
        int numberOfRecords = Integer.parseInt(numOfRecords);

        String pagesMessage = calendarEventsPage.numberOfPages.getText();
        String[] pageMessageArray = pagesMessage.split(" ");
        String pageNum=pageMessageArray[1];
        int pageNumber = Integer.parseInt(pageNum);

        calendarEventsPage.pageNumber.sendKeys("63"+ Keys.ENTER);
        BrowserUtils.waitFor(2);
        List<WebElement> rowList = calendarEventsPage.rowList;

        int totalCalendarEvents=(pageNumber-1)*25+rowList.size();

        Assert.assertEquals(numberOfRecords, totalCalendarEvents, "Verify that number of calendar events is equal to number of records");
        extentLogger.pass("PASS: Number of Records appearing on screen is equal to total number of calendar events");

    }

    @Test
    public void testCase05() {
        String testName="Verifying all calendar events are selected";
        storeManagerCalendarEvents(testName);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        calendarEventsPage.selectAllCheckbox.click();
        extentLogger.info("Select-All checkbox is clicked");

        List<WebElement> checkboxList = calendarEventsPage.checkboxList;

        for (WebElement checkbox : checkboxList) {
            Assert.assertTrue(checkbox.isSelected());
        }
        extentLogger.pass("PASS: All checkboxes are selected after clicking on Select-all checkbox");

    }

    @Test
    public void testCase06() {
        String testName="Verifying meeting details";
        storeManagerCalendarEvents(testName);

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        driver.findElement(By.xpath("//*[.=\"Testers meeting\"]")).click();

        extentLogger.info("Select \"Testers meeting\"");

        CalendarEventDetailsPage calendarEventDetailsPage=new CalendarEventDetailsPage();


        String actualTitle = calendarEventDetailsPage.titleValue.getText();
        String actualDescription = calendarEventDetailsPage.descriptionValue.getText();
        String actualStart = calendarEventDetailsPage.startValue.getText();
        String actualEnd = calendarEventDetailsPage.endValue.getText();
        String actualAllDayEvent = calendarEventDetailsPage.allDayEventValue.getText();
        String actualOrganizer = calendarEventDetailsPage.organizerValue.getText();
        String actualGuests = calendarEventDetailsPage.guestValue.getText();
        String actualRecurrence = calendarEventDetailsPage.recurrenceValue.getText();
        String actualCallViaHangout = calendarEventDetailsPage.callViaHangoutValue.getText();

        String expectedTitle="Testers meeting";
        String expectedDescription="This is a a weekly testers meeting";
        String expectedStart="Nov 27, 2019, 9:30 AM";
        String expectedEnd="Nov 27, 2019, 10:30 AM";
        String expectedAllDayEvent="No";
        String expectedOrganizer="Stephan Haley";
        String expectedGuests="Tom Smith";
        String expectedRecurrence="Weekly every 1 week on Wednesday";
        String expectedCallViaHangout="No";

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualDescription, expectedDescription);
        Assert.assertEquals(actualAllDayEvent, expectedAllDayEvent);
        Assert.assertEquals(actualOrganizer, expectedOrganizer);
        Assert.assertEquals(actualGuests, expectedGuests);
        Assert.assertEquals(actualRecurrence, expectedRecurrence);
        Assert.assertEquals(actualCallViaHangout, expectedCallViaHangout);
        Assert.assertEquals(actualStart, expectedStart);
        Assert.assertEquals(actualEnd, expectedEnd);

        extentLogger.pass("PASS: All actual data are same as expected data");

    }
}
