package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountSummaryStepDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @When("user is on Account Summary page")
    public void user_is_on_Account_Summary_page() {
        String expectedURL = "http://zero.webappsecurity.com/bank/account-summary.html";
        String actualURL = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("title of the page should be Zero - Account summary")
    public void title_of_the_page_should_be_Zero_Account_summary() {
        String expectedTitle = "Zero - Account summary";
        String actualTitle = Driver.get().getTitle();
    }

    @Then("Cash Accounts should be displayed")
    public void cash_Accounts_should_be_displayed() {
        Assert.assertTrue(accountSummaryPage.CashAccounts.isDisplayed());
    }

    @Then("Investment Accounts should be displayed")
    public void investment_Accounts_should_be_displayed() {
       Assert.assertTrue(accountSummaryPage.InvestmentAccounts.isDisplayed());
    }

    @Then("Credit Accounts should be displayed")
    public void credit_Accounts_should_be_displayed() {
        Assert.assertTrue(accountSummaryPage.CreditAccounts.isDisplayed());
    }

    @Then("Loan Accounts should be displayed")
    public void loan_Accounts_should_be_displayed() {
        Assert.assertTrue(accountSummaryPage.LoanAccounts.isDisplayed());
    }

    @Then("Credit Accounts table must have column {string}, {string} and {string}")
    public void credit_Accounts_table_must_have_column_and(String column1, String column2, String column3) {
        //storing all expected column names in a List of Strings
        List<String> columns = new ArrayList<>(Arrays.asList(column1, column2, column3));
        // comparing each element from the columns with each element from the CreditAccTableColumns list
        if(columns.size()==accountSummaryPage.CreditAccTableColumns.size()) {
            for (int i = 0; i < columns.size(); i++) {
                Assert.assertEquals(columns.get(i), accountSummaryPage.CreditAccTableColumns.get(i).getText());
            }
        }
    }
}
