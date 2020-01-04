package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccActivityNavigationStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        new AccountSummaryPage().clickLink(link);
        BrowserUtils.waitFor(5);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {
        String actualOption = new AccountActivityPage().getFirstSelectedOption();
        Assert.assertEquals(expectedOption, actualOption);
    }


}
