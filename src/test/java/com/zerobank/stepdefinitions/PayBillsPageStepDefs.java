package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PayBillsPageStepDefs {
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("user is on Pay Bills page")
    public void user_is_on_Pay_Bills_page() {
        new LoginStepDefs().user_is_logged_in();
        payBillsPage.PayBillsModule.click();
        String expectedURL = "http://zero.webappsecurity.com/bank/pay-bills.html";
        String actualURL = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("title of the page should be Zero - Pay Bills")
    public void title_of_the_page_should_be_Zero_Pay_Bills() {
        String expectedTitle = "Zero - Pay Bills";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("user should be able to complete payment form")
    public void user_should_be_able_to_complete_payment_form() {
        payBillsPage.amountInputBox.sendKeys("1000");
        payBillsPage.dateInputBox.sendKeys("2019-12-27");
        payBillsPage.descriptionInputBox.sendKeys("1st payment");
        payBillsPage.payButton.click();

    }

    @Then("after successful payment, the message should be displayed")
    public void after_successful_payment_the_message_should_be_displayed() {
        Assert.assertTrue(payBillsPage.successfulPaymentMSG.isDisplayed());
    }

    @Then("user completes payment form, leaves amount box blank")
    public void user_completes_payment_form_leaves_amount_box_blank() {
        payBillsPage.dateInputBox.sendKeys("2019-12-27");
        payBillsPage.descriptionInputBox.sendKeys("1st payment");
        payBillsPage.payButton.click();
    }

    @Then("Please fill out this field.  message should be displayed, with blank box {string}")
    public void please_fill_out_this_field_message_should_be_displayed_with_blank_box(String blankField) {
        WebElement targetElement = null;

        switch (blankField){
            case "date":
                targetElement = payBillsPage.dateInputBox;
                break;
            case "amount":
                targetElement = payBillsPage.amountInputBox;
                break;
        }

        String expectedMSG = "Please fill out this field.";
        String actualMSG = payBillsPage.getValidationMSG(targetElement);
        Assert.assertEquals(expectedMSG, actualMSG);
    }

    @Then("user completes payment form, leaves date box blank")
    public void user_completes_payment_form_leaves_date_box_blank() {
        payBillsPage.amountInputBox.sendKeys("1000");
        payBillsPage.descriptionInputBox.sendKeys("1st payment");
        payBillsPage.payButton.click();
    }

    @When("user types alphabetical characters in Amount field")
    public void user_types_alphabetical_characters_in_Amount_field() {
        payBillsPage.amountInputBox.sendKeys("hello");
        user_completes_payment_form_leaves_amount_box_blank();
    }

    @Then("Amount field should not accept it")
    public void amount_field_should_not_accept_it() {
        Assert.assertFalse(payBillsPage.successfulPaymentMSG.isDisplayed());
    }

    @When("user types special characters in Amount field")
    public void user_types_special_characters_in_Amount_field() {
        payBillsPage.amountInputBox.sendKeys("1234&%");
        user_completes_payment_form_leaves_amount_box_blank();
    }

    @When("user types alphabetical characters in date field")
    public void user_types_alphabetical_characters_in_date_field() {
        payBillsPage.dateInputBox.sendKeys("abcd");
        user_completes_payment_form_leaves_date_box_blank();
    }

    @Then("date field should not accept it")
    public void date_field_should_not_accept_it() {
        payBillsPage.dateInputBox.sendKeys("abcd");
        please_fill_out_this_field_message_should_be_displayed_with_blank_box("date");
    }

}
