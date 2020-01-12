package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class AccountActivityPage extends BasePage{


    @FindBy(id = "aa_accountId")
    public WebElement dropdownMenu;

    @FindAll(@FindBy(xpath = "//thead//th"))
    public List<WebElement> tableHeader;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = "[type='submit']")
    public WebElement find;

    // all results after "Find Transactions" search, under Date Column
    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]"))
    public List<WebElement> dateColumn;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    // all results after "Find Transactions" search, under Description Column
    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]"))
    public List<WebElement> descriptionColumn;

    @FindBy(css = "div.well")
    public WebElement noResultsMSG;

    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]"))
    public List<WebElement> depositColumn;

    @FindAll(@FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]"))
    public List<WebElement> withdrawalColumn;

    @FindBy(id = "aa_type")
    public WebElement selectType;

}
