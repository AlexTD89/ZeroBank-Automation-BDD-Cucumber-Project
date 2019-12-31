package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineStatementsPage extends BasePage {

    @FindBy(linkText = "2009")
    public WebElement _2009;

    @FindBy(linkText = "2010")
    public WebElement _2010;

    @FindBy(linkText = "2011")
    public WebElement _2011;

    @FindBy(linkText = "2012")
    public WebElement _2012;
}
