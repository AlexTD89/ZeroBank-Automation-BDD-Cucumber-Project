package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement dropdownMenu;

    @FindAll(@FindBy(xpath = "//thead//th"))
    public List<WebElement> tableHeader;


}
