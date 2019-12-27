package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//h2[.='Cash Accounts']")
    public WebElement CashAccounts;

    @FindBy(xpath = "//h2[.='Investment Accounts']")
    public WebElement InvestmentAccounts;

    @FindBy(xpath = "//h2[.='Credit Accounts']")
    public WebElement CreditAccounts;

    @FindBy(xpath = "//h2[.='Loan Accounts']")
    public WebElement LoanAccounts;

    @FindAll(@FindBy(xpath = "//div[@class='board'][3]//tr/th"))
    public List<WebElement> CreditAccTableColumns;
}
