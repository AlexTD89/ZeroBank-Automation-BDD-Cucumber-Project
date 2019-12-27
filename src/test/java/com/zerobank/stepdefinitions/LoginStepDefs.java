package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    public static String    username = ConfigurationReader.get("username"),
                            password = ConfigurationReader.get("password"),
                            wrongUsername = ConfigurationReader.get("wrongUsername"),
                            wrongPassword = ConfigurationReader.get("wrongPassword"),
                            url = ConfigurationReader.get("url");

    @Given("user is logged in")
    public void user_is_logged_in() {
        user_is_on_login_page();
        user_enters_credentials();
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.get().get(url);
        loginPage.signInButton.click();
    }

    @Then("user enters credentials")
    public void user_enters_credentials() {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("authorized user should be able to login")
    public void authorized_user_should_be_able_to_login() {
        Assert.assertEquals(username, loginPage.usernameMenu.getText());
    }

    @Then("account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
       String expectedURL = "http://zero.webappsecurity.com/bank/account-summary.html";
       String actualURL = Driver.get().getCurrentUrl();
       Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("user enters credentials with WRONG USERNAME")
    public void user_enters_credentials_with_WRONG_USERNAME() {
        loginPage.username.sendKeys(wrongUsername);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("user should not able to login")
    public void user_should_not_able_to_login() {
     String expectedURL = "http://zero.webappsecurity.com/login.html?login_error=true";
     String actualURL = Driver.get().getCurrentUrl();
     Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("user enters credentials with WRONG PASSWORD")
    public void user_enters_credentials_with_WRONG_PASSWORD() {
       loginPage.username.sendKeys(username);
       loginPage.password.sendKeys(wrongPassword);
        loginPage.loginButton.click();
    }

    @When("user enters credentials with BLANK USERNAME")
    public void user_enters_credentials_with_BLANK_USERNAME() {
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @When("user enters credentials with BLANK PASSWORD")
    public void user_enters_credentials_with_BLANK_PASSWORD() {
        loginPage.username.sendKeys(username);
        loginPage.loginButton.click();
    }

    @Then("login error message should be displayed")
    public void login_error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.loginErrorMSG.isDisplayed());
    }
}
