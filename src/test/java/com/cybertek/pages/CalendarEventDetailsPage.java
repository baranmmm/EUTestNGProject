package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventDetailsPage extends BasePage{

    public CalendarEventDetailsPage() {
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[1]//div[@class=\"controls\"]/div")
    public WebElement titleValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[2]//div[@class=\"controls\"]/div")
    public WebElement descriptionValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[3]//div[@class=\"controls\"]/div")
    public WebElement startValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[4]//div[@class=\"controls\"]/div")
    public WebElement endValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[5]//div[@class=\"controls\"]/div")
    public WebElement allDayEventValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[6]//div[@class=\"controls\"]/div")
    public WebElement organizerValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[7]//div[@class=\"controls\"]/div//a")
    public WebElement guestValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[8]//div[@class=\"controls\"]/div")
    public WebElement recurrenceValue;

    @FindBy(xpath = "(//div[@class=\"control-group attribute-row\"])[9]//div[@class=\"controls\"]/div")
    public WebElement callViaHangoutValue;




}
