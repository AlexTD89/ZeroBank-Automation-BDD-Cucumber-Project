package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class AddNewPayeeStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new LoginStepDefs().user_is_logged_in();
        BrowserUtils.waitForPresenceOfElement(By.id("pay_bills_tab"),3);
        payBillsPage.PayBillsModule.click();
        payBillsPage.addNewPayeeTab.click();

    }

//    @Given("creates new payee using following information")
//    public void creates_new_payee_using_following_information(List<String> list) {
//        System.out.println(list);
//        payBillsPage.newPayeeName.sendKeys(list.get(1));
//        payBillsPage.newPayeeAddress.sendKeys(list.get(3));
//        payBillsPage.newPayeeAcc.sendKeys(list.get(5));
//        payBillsPage.newPayeeDetails.sendKeys(list.get(7));
//        payBillsPage.addNewPayeeButton.click();
//
//    }

    /**
     * Same method as the one above, does same functionality
     * what's different:
     *          this method uses Map instead of List
     *
     * @param userData
     */
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> userData) {
        payBillsPage.newPayeeName.sendKeys(userData.get("Payee Name"));
        payBillsPage.newPayeeAddress.sendKeys(userData.get("Payee Address"));
        payBillsPage.newPayeeAcc.sendKeys(userData.get("Account"));
        payBillsPage.newPayeeDetails.sendKeys(userData.get("Payee details"));
        payBillsPage.addNewPayeeButton.click();

    }

    @Then("message The new payee The Law Offices of Hyde, Price & Sharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Sharks_was_successfully_created_should_be_displayed() {
        Assert.assertTrue(payBillsPage.successAddingNewPayeeMSG.isDisplayed());
    }
}
