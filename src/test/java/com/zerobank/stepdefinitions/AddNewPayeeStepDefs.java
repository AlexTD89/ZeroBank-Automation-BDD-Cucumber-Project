package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AddNewPayeeStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new LoginStepDefs().user_is_logged_in();
        payBillsPage.PayBillsModule.click();
        payBillsPage.addNewPayeeTab.click();

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(List<String> list) {
        System.out.println(list);
        payBillsPage.newPayeeName.sendKeys(list.get(1));
        payBillsPage.newPayeeAddress.sendKeys(list.get(3));
        payBillsPage.newPayeeAcc.sendKeys(list.get(5));
        payBillsPage.newPayeeDetails.sendKeys(list.get(7));
        payBillsPage.addNewPayeeButton.click();

    }

    @Then("message The new payee The Law Offices of Hyde, Price & Sharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Sharks_was_successfully_created_should_be_displayed() {
        Assert.assertTrue(payBillsPage.successAddingNewPayeeMSG.isDisplayed());
    }
}
