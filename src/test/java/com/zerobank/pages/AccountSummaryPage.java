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

    @FindBy(xpath = "//a[.='Savings']")
    public WebElement savingsLink;

    @FindBy(xpath = "//a[.='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//a[.='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[.='Credit Card']")
    public WebElement creditCardLink;

    @FindBy(xpath = "//a[.='Loan']")
    public WebElement loanLink;

    public void clickLink(String link){
        switch (link){
            case "Savings":
                new AccountSummaryPage().savingsLink.click();
                break;
            case "Brokerage":
                new AccountSummaryPage().brokerageLink.click();
                break;
            case "Checking":
                new AccountSummaryPage().checkingLink.click();
                break;
            case "Credit Card":
                new AccountSummaryPage().creditCardLink.click();
                break;
            case "Loan":
                new AccountSummaryPage().loanLink.click();
                break;
            default:
                System.out.println("no such link present on the page");
        }
    }
}
