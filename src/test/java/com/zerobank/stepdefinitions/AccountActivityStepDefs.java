package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AccountActivityStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("user navigates to Account Activity page")
    public void user_is_on_Account_Activity_page() {
        new AccountActivityPage().AccountActivityModule.click();
        String expectedURL = "http://zero.webappsecurity.com/bank/account-activity.html";
        String actualURL = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("Account Activity page is displayed")
    public void account_Activity_page_is_displayed() {
        Assert.assertTrue(new AccountActivityPage().AccountActivityModule.isEnabled());
    }

    @Then("title of the page should be Zero – Account activity")
    public void title_of_the_page_should_be_Zero_Account_activity() {
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("In the Account drop down default option should be Savings")
    public void in_the_Account_drop_down_default_option_should_be_Savings() {
        String expectedDefaultOption = "Savings";
        //creating object of the select class
        Select select = new Select(accountActivityPage.dropdownMenu);
        String actualDefaultOption = select.getFirstSelectedOption().getText();
        //comparing actual with expected
        Assert.assertEquals(expectedDefaultOption, actualDefaultOption);
    }

    @Then("drop down menu should have the following options: Savings, Checking, Loan, Credit Card, Brokerage")
    public void drop_down_menu_should_have_the_following_options_Savings_Checking_Loan_Credit_Card_Brokerage() {
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Loan", "Credit Card", "Brokerage"));

        //creating object of the select class
        Select select = new Select(accountActivityPage.dropdownMenu);
        List<WebElement> actualOptionsList = select.getOptions();

        //converting webElement List to String List
        List<String> actualOptions = new ArrayList<>();
        for (WebElement actualOption : actualOptionsList) {
            actualOptions.add(actualOption.getText());
        }

        System.out.println(actualOptions);
        //comparing actual with expected
        Collections.sort(actualOptions);
        Collections.sort(expectedOptions);
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @Then("following columns should be displayed: Date, Description, Deposit, Withdrawal")
    public void following_columns_should_be_displayed_Date_Description_Deposit_Withdrawal() {
        List<String> expectedColumns = new ArrayList<>(Arrays.asList("Date", "Description", "Deposit", "Withdrawal"));
        if (expectedColumns.size() == accountActivityPage.tableHeader.size()) {
            for (int i = 0; i < expectedColumns.size(); i++) {
                Assert.assertEquals(expectedColumns.get(i), accountActivityPage.tableHeader.get(i).getText());
            }
        }
    }
}
