package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;




    @FindBy(xpath = "//div[contains(text(), \"Options\")]")
    public WebElement subtitleOptions;

    @FindBy(xpath = "//input[@type=\"number\"]")
    public WebElement pageNumber;

    @FindBy(xpath = "//div[@class=\"btn-group\"]//button[@data-toggle=\"dropdown\"]")
    public WebElement viewPerPageNumber;

    @FindBy(xpath = "//label[@class=\"dib\"][3]")
    public WebElement numberOfRecords;

    @FindBy(xpath = "//label[@class=\"dib\"][2]")
    public WebElement numberOfPages;

    @FindBy(className = "grid-row")
    public List<WebElement> rowList;

    @FindBy(xpath = "//button//input[@type=\"checkbox\"]")
    public WebElement selectAllCheckbox;

    @FindBy(css= "[data-role=\"select-row-cell\"]")
    public List<WebElement> checkboxList;








}