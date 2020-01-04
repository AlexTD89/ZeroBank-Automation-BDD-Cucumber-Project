package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();


    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new LoginStepDefs().user_is_logged_in();
        payBillsPage.PayBillsModule.click();
        payBillsPage.purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedOptions) {
        Select select = new Select(payBillsPage.currencySelect);
        List<String> actualOptions = BrowserUtils.getElementsText(select.getOptions());
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.currencyAmount.sendKeys("100");
        payBillsPage.selectUSD.click();
        payBillsPage.calculateCostsButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String expectedMSG = "Please, ensure that you have filled all the required fields with valid values.";
        String actualMSG = alert.getText();
        if(alert.getText().isEmpty()){
            throw new NoSuchFrameException("No popUP Alert Appeared");
        }else{
            Assert.assertEquals(expectedMSG, actualMSG);
        }
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select select = new Select(payBillsPage.currencySelect);
        select.selectByVisibleText("China (yuan)");
        payBillsPage.selectOtherCurrency.click();
        payBillsPage.calculateCostsButton.click();
    }

}
