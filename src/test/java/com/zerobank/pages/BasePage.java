package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(xpath = "//i[@class='icon-user']//..")
    public WebElement usernameMenu;

    @FindBy(linkText = "Account Activity")
    public WebElement AccountActivityModule;

    @FindBy(id = "pay_bills_tab")
    public WebElement PayBillsModule;

    @FindBy(linkText = "Online Statements")
    public WebElement onlineStatementsModule;

}
