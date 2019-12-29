package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @FindBy(id = "sp_payee")
    public WebElement payeeSelectMenu;

    @FindBy(id = "sp_account")
    public WebElement accountSelectMenu;

    @FindBy(id = "sp_amount")
    public WebElement amountInputBox;

    @FindBy(id = "sp_date")
    public WebElement dateInputBox;

    @FindBy(id = "sp_description")
    public WebElement descriptionInputBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//span[.='The payment was successfully submitted.']")
    public WebElement successfulPaymentMSG;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayeeTab;

    @FindBy(id = "np_new_payee_name")
    public WebElement newPayeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement newPayeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement newPayeeAcc;

    @FindBy(id = "np_new_payee_details")
    public WebElement newPayeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addNewPayeeButton;

    @FindBy(id = "alert_content")
    public WebElement successAddingNewPayeeMSG;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement currencySelect;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

    @FindBy(id = "pc_amount")
    public WebElement currencyAmount;

    @FindBy(id = "pc_inDollars_true")
    public WebElement selectUSD;

    @FindBy(id = "pc_inDollars_false")
    public WebElement selectOtherCurrency;

    public String getValidationMSG(WebElement webElement){
        String validationMSG = webElement.getAttribute("validationMessage");
        return validationMSG;
    }
}
